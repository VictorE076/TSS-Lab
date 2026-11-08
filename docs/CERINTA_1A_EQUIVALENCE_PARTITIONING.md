# Cerinta 1.a - Equivalence Partitioning

## Partitionarea in clase de echivalenta

Se considera metoda `IncreasingSequenceAnalyzer.analyze(int[] scores)`, care analizeaza evolutia scorurilor unui participant.

Metoda primeste un vector de scoruri si determina daca exista cel putin doua secvente maximale strict crescatoare, fiecare cu lungime de minimum 3, iar suma ultimelor elemente ale tuturor acestor secvente este cel putin 80.

Un vector este valid daca are intre 6 si 12 elemente, iar fiecare element apartine intervalului $[0, 100]$.

### Clasele datelor de intrare

Notam cu $v$ vectorul de intrare, cu $|v|$ lungimea acestuia si cu $v[i]$ elementul de pe pozitia $i$.

Definim urmatoarele clase:

$$
N_1 = \{v \mid v \neq \mathrm{null},\ 6 \leq |v| \leq 12,\ \forall i:\ 0 \leq v[i] \leq 100\}
$$

$$
N_2 = \{v \mid v = \mathrm{null}\}
$$

$$
N_3 = \{v \mid v \neq \mathrm{null},\ |v| < 6\}
$$

$$
N_4 = \{v \mid v \neq \mathrm{null},\ |v| > 12\}
$$

$$
N_5 = \{v \mid v \neq \mathrm{null},\ 6 \leq |v| \leq 12,\ \exists i:\ v[i] < 0\}
$$

$$
N_6 = \{v \mid v \neq \mathrm{null},\ 6 \leq |v| \leq 12,\ \forall i:\ v[i] \geq 0,\ \exists i:\ v[i] > 100\}
$$

Indicii $i$ sunt considerati in intervalul $0 \leq i < |v|$.

- **N₁** – vector valid.
- **N₂** – referinta nula.
- **N₃** – lungime mai mica de 6.
- **N₄** – lungime mai mare de 12.
- **N₅** – lungime valida, dar exista cel putin un scor negativ.
- **N₆** – lungime valida, fara scoruri negative, dar exista cel putin un scor mai mare decat 100.

Pentru vectorii din $N_1$, definim urmatoarele proprietati:

$$
P_1(v):\quad k(v) \geq 2
$$

$$
P_2(v):\quad S(v) \geq 80
$$

unde:

- $k(v)$ reprezinta numarul secventelor maximale strict crescatoare, cu lungime de minimum 3.
- $S(v)$ reprezinta suma ultimelor elemente ale tuturor acestor secvente. Daca nu exista secvente relevante, $S(v)=0$.

### Clasele datelor de iesire

Definim clasele datelor de iesire:

$$
I_1 = \{\text{"DA"}\}
$$

$$
I_2 = \{\text{"NU"}\}
$$

$$
I_3 = \{\text{"Vectorul nu este valid"}\}
$$

### Clasele de echivalenta finale

Combinand clasele datelor de intrare cu proprietatile definite si cu rezultatele posibile ale metodei, obtinem:

$$
C_1 = \{v \in N_1 \mid P_1(v) \land P_2(v)\} \rightarrow I_1
$$

$$
C_2 = \{v \in N_1 \mid P_1(v) \land \neg P_2(v)\} \rightarrow I_2
$$

$$
C_3 = \{v \in N_1 \mid \neg P_1(v) \land P_2(v)\} \rightarrow I_2
$$

$$
C_4 = \{v \in N_1 \mid \neg P_1(v) \land \neg P_2(v)\} \rightarrow I_2
$$

$$
C_5 = N_2 \rightarrow I_3
$$

$$
C_6 = N_3 \rightarrow I_3
$$

$$
C_7 = N_4 \rightarrow I_3
$$

$$
C_8 = N_5 \rightarrow I_3
$$

$$
C_9 = N_6 \rightarrow I_3
$$

Au fost obtinute 9 clase de echivalenta, disjuncte si care acopera intregul domeniu de intrare.

### Datele de test

Pentru fiecare clasa de echivalenta a fost ales un reprezentant.

| Test | Clasa | Date de intrare | Rezultat asteptat |
|---|---|---|---|
| T1 | C₁ | `[10,30,50,0,20,70]` | DA |
| T2 | C₂ | `[10,20,30,0,10,40]` | NU |
| T3 | C₃ | `[10,20,90,80,70,60]` | NU |
| T4 | C₄ | `[0,0,0,0,0,0]` | NU |
| T5 | C₅ | `null` | Vectorul nu este valid |
| T6 | C₆ | `[10,20,30,0,20]` | Vectorul nu este valid |
| T7 | C₇ | `[0,1,2,3,4,5,6,7,8,9,10,11,12]` | Vectorul nu este valid |
| T8 | C₈ | `[10,30,50,0,20,-1]` | Vectorul nu este valid |
| T9 | C₉ | `[10,30,50,0,20,101]` | Vectorul nu este valid |

Pentru testele care utilizeaza vectori valizi, se obtin urmatoarele valori:

| Test | $k(v)$ | $S(v)$ | $P_1(v)$ | $P_2(v)$ |
|---|---|---|---|---|
| T1 | 2 | 120 | True | True |
| T2 | 2 | 70 | True | False |
| T3 | 1 | 90 | False | True |
| T4 | 0 | 0 | False | False |
