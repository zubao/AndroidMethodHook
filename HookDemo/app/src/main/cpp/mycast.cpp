#include <cstdint>
template<typename U, typename T>
U Reinterpret_cast(T * x){
    return (U)(uintptr_t)x;
}

template<typename U, typename T>
U Reinterpret_cast(T &x){
    return *(U*)&x;
}

#define reinterpret_cast Reinterpret_cast