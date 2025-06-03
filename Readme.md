# Hotel Management Sistem

## Dva segmenta aplikacije:
1. **Biznis segment**
2. **Tehnički segment**

---

## Biznis Segment

### Opis Informacionog Sistema
Sistem koji vode zaposleni u hotelu za vođenje rezervacija soba. Ova aplikacija je **poluzatvorenog tipa**:
- **Uposleni** će vidjeti detalje o gostima.
- **Korisnici bez punog pristupa** mogu vidjeti samo dostupnost soba.

Za početak, fokusiramo se na to da aplikaciju koriste **samo uposleni hotela**.

### Funkcionalnosti sistema
Hotel vodi evidenciju o **sobama**:
- Svaka soba ima definisan **broj gostiju** koji u njoj mogu boraviti.

Sistem rezervacije funkcioniše na **4 parametra**:
- `fromDate`
- `toDate`
- `checkin`
- `checkout`

Za svaku rezervaciju moraju postojati:
- Informacije o **gostu** na kog se vodi rezervacija.
- Informacije o **ostalim gostima** u sobi.

### Podaci o gostima
Za svakog gosta se čuva:
- **Ime** i **prezime**
- **Broj pasoša / lične karte**

### Nivoi pristupa
Sistem za početak ima **2 nivoa pristupa**:
1. **Administrator**
    - Može dodavati i brisati sobe.
2. **Employee**
    - Može upravljati rezervacijama.

> Više rezervacija jedne sobe **ne smeju** se preklapati!

---

## Tehnički Segment

### Tehnologije koje će se koristiti u projektu:
1. **JavaFX** – za frontend aplikaciju.
2. **MySQL** – baza podataka.
3. **JPA** (Hibernate ili drugi JPA ORM) – za rad sa bazom podataka.

---

## Kako doprinijeti?
Ako želiš da doprineseš razvoju, slobodno otvori **issue** ili **pull request**! 😊
