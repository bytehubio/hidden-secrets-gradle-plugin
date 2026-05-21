# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)
# Support Android 15 / 16 KB pages
set(CMAKE_ANDROID_SUPPORT_FLEXIBLE_PAGE_SIZES ON)

# Ensure GNU hash table is emitted
set(CMAKE_SHARED_LINKER_FLAGS "${CMAKE_SHARED_LINKER_FLAGS} -Wl,--hash-style=gnu")

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add_library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

add_library( # Specifies the name of the library.
        secrets

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        secrets.cpp )