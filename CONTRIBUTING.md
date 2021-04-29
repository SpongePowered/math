# Contributing

Sponge's math library is happy to accept improvements and fixes from interested contributors!

While the `math` library targets Java 8 and below at runtime, the preferred development environment is JDK 11.

Developing on the library is a bit complicated due to the use of the [Pebble] template engine -- the majority of the project's 
source is generated based on several sets of templates. Any additions should use templates wherever applicable to reduce duplication.

## Working with templates

On first import into an IDE, run the `generateTemplates` task to ensure templates have been generated. In Eclipse, 
this task is registered as an "autobuild" task, which should keep the IDE in sync with changes to templates.

There is some IDE support for the Pebble syntax. An [IntelliJ plugin](https://plugins.jetbrains.com/plugin/9407-pebble) exists, though it does 
little more than syntax highlighting.

IntelliJ also has a setting that attempts to highlight template files as Java source files 
(available under Preferences > Languages & Frameworks > Template Data Languages). This option is of varying effectiveness depending on the source file.

## Inside the template generator

*Math* uses a simple Gradle plugin that allows attaching *template sets* to Gradle source sets.

Each template set produces output from a different source directory, by default in the `src/<source set name>/template/<template set>` folder.

Within a template set, multiple *variants* can be specified. Each variant has a different set of values for template variables (though all 
variants will inherit from the overall template set). When used in combination with template parameter interpolation in file names, 
this allows creating multiple output files from one template.

While template parameters can be set programatically in the Gradle buildscript, the preferred way to do so is with data files. These are YAML 
files with a mapping at the root containing template properties. When a *template set* has *variants*, rather than being a single set, 
options can be set for multiple variants within a single file by placing them under the `mapping` 

Template parameters will override each other, inheriting in the following order (where the last element in the list takes priority):

- Template set, defined in a set data file
- Template set, defined in-buildscript
- Variant, defined in global files
- Variant, defined in the variant-specific data files
- Variant, defined in-buildscript

[Pebble]: https://pebbletemplates.io/
