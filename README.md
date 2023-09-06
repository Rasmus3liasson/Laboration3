# Laboration 3

Den här uppgiften går ut på att använda Junit5 för att skriva enhetstester samt functionell programmering med java 8 streams. Vi kommerimplementera en mindre applikation för att hantera Produkter. Alla publika metoder i klasserna ska ha tester för sin funktionalitet.

## Uppgift för G:

Kodens publika gränssnitt mot omvärlden kommer att vara en klass kallad Warehouse placerad i ett paket kallat service. Metoder som returnerar objektreferenser eller tar sådana som inparametrar ska endast använda immutable objekt. Det kan därför vara nödvändigt att skapa speciella objekt med hjälp av records i Java som information kopieras över till. Tänk också på att inte returnera en referens direkt till t.ex. en ArrayList som används för lagring av information för då kan mottagaren modifiera innehållet i listan utan att gå via våra publika metoder.

Vårt lager ska hantera produkter som minst har följande attribut:
- Ett unikt id.
- Ett namn.
- Tillhör en kategori som är en enum datatyp.
- En rating tex mellan 0-10.
- Ett datum för när produkten skapades som ej ska gå att ändra.
- Ett datum för när den modifierades senast.

För att hantera detta skapar vi en klass kallad Product som läggs i ett paket kallat entities.

Följande funktionalitet ska finnas på Warehouse som publika metoder med tillhörande tester. Kan en metod generera fel ska metoden ha ett test för lyckad körning och ett för felfallet. Flera av metoderna löses enklast med Java 8 streams:

- Lägga till en ny produkt. (Bör ha någon enkel validering så att produkter utan namn ej kan läggas till)
- Modifiera en befintlig produkt. (Byta namn, kategori, rating)
- Hämta alla produkter.
- Hämta en produkt genom produktens id.
- Hämta alla produkter som hör till en kategori sorterat efter produktnamn A-Z.
- Hämta alla produkter skapade efter ett angivet datum. (Nya produkter sen sist)
- Hämta alla produkter som modifierats sen de skapades. (Datum ej samma)

## Uppgift för VG:

Utöka Warehouse med ytterligare funktioner för:
- Hämta alla kategorier som har minst 1 produkt kopplad.
- Hämta hur många produkter det finns i en given kategori.
- Hämta en Map som innehåller alla bokstäver som produktnamn börjar på som nyckel och antalet produkter som börjar på den bokstaven som value.
- Hämta alla produkter med max rating, skapade denna månad och sorterat på datum med nyast först.
