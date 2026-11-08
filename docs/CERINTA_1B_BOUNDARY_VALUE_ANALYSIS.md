# Cerinta 1.b - Boundary Value Analysis

## Analiza valorilor de frontiera

Se identifica urmatoarele conditii si valori de frontiera:

**1. Lungimea vectorului**

$$
6 \leq n \leq 12
$$

$$
n \in \{5,6,7,11,12,13\}
$$

**2. Valorile elementelor vectorului**

$$
0 \leq v[i] \leq 100
$$

$$
v[i] \in \{-1,0,1,99,100,101\}
$$

**3. Lungimea unei secvente relevante**

$$
l \geq 3
$$

$$
l \in \{2,3,4\}
$$

**4. Numarul secventelor relevante**

$$
k \geq 2
$$

$$
k \in \{1,2,3\}
$$

**5. Suma ultimelor elemente ale secventelor relevante**

$$
S \geq 80
$$

$$
S \in \{79,80,81\}
$$

**6. Conditia de crestere stricta**

$$
v[i] > v[i-1]
$$

Notam diferenta dintre doua elemente consecutive cu:

$$
d = v[i]-v[i-1]
$$

$$
d \in \{-1,0,1\}
$$

## Datele de test

### A. Lungimea vectorului

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T1 | n = 5 | `[0,0,0,0,0]` | Vectorul nu este valid |
| T2 | n = 6 | `[0,0,0,0,0,0]` | NU |
| T3 | n = 7 | `[0,0,0,0,0,0,0]` | NU |
| T4 | n = 11 | `[0,0,0,0,0,0,0,0,0,0,0]` | NU |
| T5 | n = 12 | `[0,0,0,0,0,0,0,0,0,0,0,0]` | NU |
| T6 | n = 13 | `[0,0,0,0,0,0,0,0,0,0,0,0,0]` | Vectorul nu este valid |

### B. Limita inferioara a scorurilor

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T7 | -1 | `[-1,20,40,0,20,40]` | Vectorul nu este valid |
| T8 | 0 | `[0,20,40,0,20,40]` | DA |
| T9 | 1 | `[1,20,40,0,20,40]` | DA |

### C. Limita superioara a scorurilor

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T10 | 99 | `[0,20,40,0,20,99]` | DA |
| T11 | 100 | `[0,20,40,0,20,100]` | DA |
| T12 | 101 | `[0,20,40,0,20,101]` | Vectorul nu este valid |

### D. Lungimea secventelor relevante

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T13 | l = 2 | `[0,20,40,0,40,0]` | NU |
| T8 | l = 3 | `[0,20,40,0,20,40]` | DA |
| T14 | l = 4 | `[0,10,20,40,0,20,40]` | DA |

Pentru T13 exista o secventa relevanta de lungime 3 si o secventa de lungime 2, care nu este considerata relevanta. Rezultatul este `"NU"`.

Pentru T8 exista doua secvente relevante de lungime 3, iar pentru T14 exista doua secvente relevante de lungimi 4 si 3.

### E. Numarul secventelor relevante

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T15 | k = 1 | `[0,20,80,0,0,0]` | NU |
| T8 | k = 2 | `[0,20,40,0,20,40]` | DA |
| T16 | k = 3 | `[0,10,30,0,10,30,0,10,30]` | DA |

Pentru T15 exista o singura secventa relevanta, iar suma este 80.

Pentru T8 exista doua secvente relevante, cu suma 80.

Pentru T16 exista trei secvente relevante, cu suma 90.

### F. Suma ultimelor elemente ale secventelor relevante

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T17 | S = 79 | `[0,10,39,0,10,40]` | NU |
| T8 | S = 80 | `[0,20,40,0,20,40]` | DA |
| T18 | S = 81 | `[0,10,41,0,10,40]` | DA |

Toate cele trei teste contin doua secvente relevante. Rezultatul depinde de compararea sumei ultimelor elemente cu pragul 80.

### G. Conditia de crestere stricta

| Test | Valoare | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T19 | d = -1 | `[0,40,80,0,20,19]` | NU |
| T20 | d = 0 | `[0,40,80,0,20,20]` | NU |
| T21 | d = 1 | `[0,40,80,0,20,21]` | DA |

Pentru T19, ultimul scor este mai mic decat precedentul, iar pentru T20 cele doua scoruri sunt egale. In ambele cazuri exista o singura secventa relevanta.

Pentru T21, ultima pereche este strict crescatoare. Exista doua secvente relevante, iar suma ultimelor elemente este 101.