English | [简体中文](./README.cn.md)

# DataStructureVisualizer

## Introduction

#### Overview

**DataStructureVisualizer** is a PC desktop application that provides visualization and interaction of algorithms and data structures, and supports programmers (even newbies) to simply extend it.

*For convenience of description, we will abbreviate the data structure (or algorithm) visualized by the application as **VDS**.*

#### Features

With this visualization tool, you can:

- See the visual elements of the logical structure of VDS;

- See an animation of the algorithm execution process and data structure maintenance process;

- See code traces of performed VDS operations synchronized with the animation;

- See the output of various operations of the VDS.

And you can also interact with the VDS, for example:

- Let the VDS perform the operation specified by the user;

- Set animation parameters, such as adjusting the animation playback rate and setting whether to play in a single step;

- Control the detail-level of the output, such as requiring all intermediate DEBUG information to be output or only the final result.

What's more, the programmers can add user-defined VDS by themselves.

Importantly, They don't need to read and understand the source code of the application. They just need to consult the developer manual provided by us. The only condition is that the programmers should has at least a basic understanding of Java syntax, and they need to follow some preset rules while extending.

However, the extension is limited. At present, the tool only supports VDSs based on one or more of the following logical structures:

- Linear List (including Sequential List and Linked List);

- Binary Tree.

Obviously supporting only the above is insufficient, so I plan to add support for the following logical structures in future versions:

- Two-dimensional nested Linear List (including Sequential List and Linked List, cross-nesting supported);

- K-ary Tree;

- Graph (simple structure only).

## Installation

#### Option 1 : Download the pre-compiled jar package or exe file

In order to help those who have no experience with Java to get started quickly, I prepared pre-compiled jar package and exe file, which can be downloaded from the following URL. However, these may not be the latest version.

[(Download_address_has_not_been_set)](blog.jm233333.com)

For any PC user, you can directly download the compressed package containing the jar package, decompress it, and run the `.jar` file directly to launch the application. However, you must download and configure JRE 1.8+ before you can run the `.jar` file.

If you are a Windows user, you can also directly download the compressed package containing the exe file, decompress it, and run the `.exe` file directly to launch the application. In this way, you don't need to configure the JRE.

*Notice: JRE 1.8 or higher version is required.*

#### Option 2 : Download and compile the source code

If you have experience with Java, you can clone or download the source code from the project's GitHub page, and then build the project using Ant or any IDE (such as Ecllipse, IDEA, etc.).

The easiest way is to compile directly with Ant, but you must first download and configure JDK 1.8+ and Apache Ant 1.10.x. After completing the configuration, go to the root directory of the source code folder, open the CLI, and run the following command:

```
ant all
```

If the build is successful, you will see the prompt `BUILD SUCCESSFUL` in the command line, and you can find the following in `out/artifacts/` :

```
custom/
lib/
DataStructureVisualizer.jar
```

Run the `.jar` file directly to launch the application.

*Notice: JDK 1.8 or higher version is required. If you build the project with Ant, 1.10.x is required.*

## Quick Start

## More

## Change Log (after 2020.3)

| Date | Updates |
| :--- | :--- |
| 2020.3.5 | All basic features are implemented. |
| 2020.3.17 | Adds support for compilation with Ant. |