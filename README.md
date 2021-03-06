# PokeData
[![Travis CI](https://travis-ci.org/hugmanrique/PokeData.svg?branch=master)](https://travis-ci.org/hugmanrique/PokeData/) [![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

Pokémon data classes from Gen III that can read from a ROM.

## ROM reader and writer
PokeData provides a [ROM](src/main/java/me/hugmanrique/pokedata/utils/ROM.java) interface which contains all the ROM reading and writing methods.

You can make your ROM readable-only by leaving the `writeByte(byte value, int offset)` method empty.

You can find a guide on how to load the `PokeTable` and a base `ROM` class in the [PokeDataTest](https://github.com/hugmanrique/PokeDataTest) repo.

## Data reference:
All the classes contain an URL to Bulbapedia if available, where the data values are explained in more depth.

- Items: Item metadata
- Moves: Move metadata
- Pokédex: details about a Pokémon species
- PokemonBaseStats: Base status of a Pokémon species
- Pokémon: basic data of a captured Pokémon
- PokemonData: battle data of a captured Pokémon
- Evolutions: Evolution metadata
- Types: Effectiveness of each type against others
- Trainer: Sprites, party, double battle, music, items...

### Map structures:
As the structure of a Map is complex, every section receives its own class:

- Map: base class for a map
- MapHeader: Map metadata
- ConnectionData: Connection pointers and list of them
- Connection: offset, borders, map destination...
- [Sprites](#sprites)

Special thanks to [@shinyquagsire23](https://github.com/shinyquagsire23/) for finding out all the data structures for this section.
These values were extracted from his project [MEH](https://github.com/shinyquagsire23/MEH), check it out!

### Sprites
PokeData has base classes for Sprites and a SpriteManager, which creates the sprite instances; here are the different types currently implemented:

- NPCs: trainer that have scripts (speeches, combats...)
- Signs: contains the pointer to the text pointer and metadata
- Triggers: also known as traps, calls scripts when passing over a tile
- Exits: move the player to other map locations, contains the Bank and the Map ID
- OverworldSprites: (Soon) raw images of the overworld sprites, offers methods to render into Java's Images

## Image rendering system
PokeData provides an intelligent way to load GBA images with a [Palette](src/main/java/me/hugmanrique/pokedata/graphics/Palette.java) and render it into a [BufferedImage](https://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferedImage.html) by using the [ROMImage](src/main/java/me/hugmanrique/pokedata/graphics/ROMImage.java) class.

The [ImageUtils](src/main/java/me/hugmanrique/pokedata/utils/ImageUtils.java) provides ways to load Lz77 compressed palettes and images with a cache system to improve load times for duplicate reads.

## Tests
As redistributing original GBA ROM Pokémon images is illegal, please place a `tests.gba` FireRed ROM file on this directory and then run the tests with Maven. If no ROM file is found, some tests will silently pass.

----

![YourKit logo](https://www.yourkit.com/images/yklogo.png)

The PokeData project uses the YourKit Java Profiler to improve performance. We'd like to thank them for their amazing tool and recommend them to all Java developers!

YourKit supports open source projects with its full-featured Java Profiler.
YourKit, LLC is the creator of [YourKit Java Profiler](https://www.yourkit.com/java/profiler/)
and [YourKit .NET Profiler](https://www.yourkit.com/.net/profiler/),
innovative and intelligent tools for profiling Java and .NET applications.