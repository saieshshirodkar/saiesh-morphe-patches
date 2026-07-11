package app.template.patches.shared

import app.morphe.patcher.patch.PatchException
import app.morphe.patcher.extensions.InstructionExtensions.addInstructions
import app.morphe.patcher.util.proxy.mutableTypes.MutableMethod
import com.android.tools.smali.dexlib2.builder.BuilderTryBlock
import com.android.tools.smali.dexlib2.builder.MutableMethodImplementation
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType

fun MutableMethod.clearBody() {
    val impl = implementation ?: return
    val field = tryBlocksField
        ?: throw PatchException(
            "MutableMethodImplementation has no List<BuilderTryBlock> field. dexlib2 layout changed?",
        )
    @Suppress("UNCHECKED_CAST")
    (field.get(impl) as MutableList<BuilderTryBlock>).clear()
    val n = impl.instructions.toList().size
    repeat(n) { impl.removeInstruction(0) }
}

fun MutableMethod.ensureRegisters(needed: Int) {
    val impl = implementation ?: return
    if (impl.registerCount >= needed) return
    val field = registerCountField
        ?: throw PatchException(
            "MutableMethodImplementation has no `int` field named 'registerCount' " +
                "(scanned all declared fields). dexlib2 internal layout changed?",
        )
    field.setInt(impl, needed)
}

fun MutableMethod.returnEarly() = addInstructions(
    0,
    when (returnType) {
        "V" -> "return-void"
        "Z", "B", "C", "S", "I", "F" -> "const/4 v0, 0x0\nreturn v0"
        "J", "D" -> "const-wide/16 v0, 0x0\nreturn-wide v0"
        else -> "const/4 v0, 0x0\nreturn-object v0"
    },
)

private val registerCountField: Field? = run {
    MutableMethodImplementation::class.java.declaredFields
        .firstOrNull { it.type == Int::class.javaPrimitiveType }
        ?.apply { isAccessible = true }
}

private val tryBlocksField: Field? = run {
    MutableMethodImplementation::class.java.declaredFields
        .firstOrNull { f ->
            if (!MutableList::class.java.isAssignableFrom(f.type) &&
                !List::class.java.isAssignableFrom(f.type)
            ) return@firstOrNull false
            val generic = f.genericType as? ParameterizedType ?: return@firstOrNull false
            val arg = generic.actualTypeArguments.firstOrNull() ?: return@firstOrNull false
            arg.typeName == BuilderTryBlock::class.java.name ||
                arg.typeName.startsWith("${BuilderTryBlock::class.java.name}<")
        }
        ?.apply { isAccessible = true }
}
