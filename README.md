# Saiesh's Morphe Patches

Patches for apps requested by people.

## Patches

| App | Package | Version | Patches | Play Store |
| --- | --- | --- | --- | --- |
| Lightroom | `com.adobe.lrmobile` | 11.4.4 | Disable PairIP DRM, Unlock Premium | [Play Store](https://play.google.com/store/apps/details?id=com.adobe.lrmobile) |
| AT4K Launcher | `com.overdevs.at4k` | 0.99 | Disable PairIP DRM, Unlock Premium | [Play Store](https://play.google.com/store/apps/details?id=com.overdevs.at4k&hl=en_IN) |

Add this URL in Morphe Manager > Settings > Patch sources:

```
https://github.com/saieshshirodkar/saiesh-morphe-patches
```

## Building

```bash
./gradlew :patches:build
```

Output: `patches/build/libs/patches-*.mpp`

## Disclaimer

Use at your own risk. There could be bugs or issues — please report them in the [Issues](https://github.com/saieshshirodkar/saiesh-morphe-patches/issues) section.

## Donate

- **UPI:** shirodkarsrk@oksbi
- **PayPal:** shirodkarsrk@gmail.com

## Credits

- [MorpheApp](https://github.com/MorpheApp) - The patcher framework
- [rushi/morphe-patches](https://github.com/rushiranpise/morphe-patches) - Reference implementation

## License

GNU General Public License v3.0
