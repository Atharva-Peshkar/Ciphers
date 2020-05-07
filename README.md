# Ciphers
This repository contains the implementation of major classical ciphers in Kotlin.

A cipher is an algorithm for performing encryption or decryption—a series of well-defined steps that can be followed as a procedure. 

1) Caesar Cipher: The Caesar Cipher technique is one of the earliest and simplest method of encryption technique. It’s simply a type of substitution cipher, i.e., each letter of a given text is replaced by a letter some fixed number of positions down the alphabet. 

The encryption can be represented using modular arithmetic by first transforming the letters into numbers, according to the scheme, A = 0, B = 1,…, Z = 25. Encryption of a letter by a shift n can be described mathematically as.

E[n](x)=((x+n-ASCII(A))mod(26))+ASCII(A)          * Replace 'A' with 'a'  for lowercase alphabets
(Encryption Phase with shift n)

D[n](x)=((x-n-ASCII(A))mod(26))+ASCII(A)          * Replace 'A' with 'a'  for lowercase alphabets
(Decryption Phase with shift n)

2) Vigenère Cipher: D[i] denotes the offset of the i-th character of the plaintext. 

Encryption: The plaintext(P) and key(K) are added modulo 26.
E[i] = (P[i] + K[i]) mod 26

Decryption:
D[i] = (E[i] - K[i] + 26) mod 26
