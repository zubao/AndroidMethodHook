cmake_minimum_required(VERSION 3.10)

add_definitions("-Wno-error=format-security -fpermissive")
add_definitions("-fno-rtti -fno-exceptions")
add_definitions("-fvisibility=hidden -O3")
add_definitions("-std=gnu++11 -DDEBUG -O0")

add_library(nativemode

        SHARED
        src/main/cpp/mycast.cpp
        src/main/cpp/davilk.h
        src/main/cpp/NativeHelper.h
        src/main/cpp/NativeHelper.cpp)


find_library(log-lib
    log)

target_link_libraries(
    nativemode

    ${log-lib}
)