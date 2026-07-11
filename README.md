# Saiesh's Morphe Patches

Patches for apps requested by people.

## Patches

| App | Package | Version | Patches |
|---|---|---|---|
| Lightroom | com.adobe.lrmobile | 11.4.4 | Disable PairIP DRM, Unlock Premium |

Add this URL in Morphe Manager > Settings > Patch sources:

```
https://github.com/saieshshirodkar/saiesh-morphe-patches
```

## Building

```bash
./gradlew :patches:build
```

Output: `patches/build/libs/patches-*.mpp`

## License

GNU General Public License v3.0
