# Specificatia problemei

## Analiza evolutiei scorurilor unui participant

### 1. Descrierea problemei

In cadrul unei platforme educationale, un participant obtine mai multe scoruri la o serie de teste, sustinute in ordine cronologica.

Se considera un vector de numere intregi care contine scorurile obtinute de participant, in ordinea sustinerii testelor.

Scopul programului este identificarea unor perioade de crestere consecutiva a scorurilor si verificarea indeplinirii unor conditii prestabilite.

### 2. Date de intrare

Programul primeste un vector de numere intregi `scores`, care trebuie sa respecte urmatoarele conditii:

- Referinta catre vector nu poate fi `null`.
- Vectorul trebuie sa contina intre 6 si 12 elemente, inclusiv.
- Fiecare element reprezinta un scor intreg cuprins intre 0 si 100, inclusiv.
- Elementele sunt ordonate cronologic.

### 3. Definitia unei secvente relevante

O secventa maximală strict crescatoare reprezinta o succesiune de elemente consecutive din vector, in care fiecare element este strict mai mare decat precedentul.

Secventa este maximala daca nu poate fi extinsa la stanga sau la dreapta, pastrand ordinea strict crescatoare.

Se considera relevante numai secventele maximale care contin cel putin 3 elemente.

### 4. Conditiile de verificat

Programul determina daca sunt indeplinite simultan urmatoarele conditii:

1. Exista cel putin doua secvente maximale strict crescatoare relevante.
2. Suma ultimelor scoruri ale tuturor secventelor relevante este mai mare sau egala cu 80.

### 5. Date de iesire

Metoda returneaza un rezultat de tip `String`:

- `"DA"` – ambele conditii sunt indeplinite.
- `"NU"` – vectorul este valid, dar cel putin una dintre conditii nu este indeplinita.
- `"Vectorul nu este valid"` – referinta este nula, dimensiunea vectorului este invalida sau exista cel putin un scor in afara intervalului permis.

### 6. Exemplu

Pentru vectorul:

`[10, 30, 50, 0, 20, 70]`

Se identifica doua secvente maximale strict crescatoare relevante:

- `[10, 30, 50]` – lungime 3, ultimul scor 50.
- `[0, 20, 70]` – lungime 3, ultimul scor 70.

Numarul secventelor relevante este 2.

Suma ultimelor scoruri este 50 + 70 = 120.

Deoarece sunt indeplinite ambele conditii, programul returneaza `"DA"`.

### 7. Precizari

- Programul nu modifica vectorul primit.
- Sunt analizate toate secventele maximale strict crescatoare.
- Secventele cu lungime mai mica de 3 nu contribuie la numarul secventelor relevante sau la suma calculata.
- Pentru un vector invalid, programul returneaza mesajul de eroare fara a efectua analiza secventelor.
