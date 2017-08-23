#ifndef __SWAP_H
#define __SWAP_H

template <typename T>
T swapTemplate(T &a, T &b) {
   T c = a;
   a = b;
   b = c;
}

#endif