# Vis antal åbne tasks

## User story

Som bruger vil jeg kunne se, hvor mange tasks der endnu ikke er færdige.

## Acceptkriterier

- Brugeren kan vælge et menupunkt, der viser antal ikke-færdige tasks
- Kun tasks hvor completed er false tælles med
- Hvis der ikke findes tasks, skal programmet vise 0
- Programmet må ikke crashe
- Den eksisterende funktionalitet må ikke ændres

## Teknisk afgrænsning

- Behold konsolapplikationen
- Behold array-løsningen
- Brug ikke database
- Brug ikke webframework
- Ændr kun service-klassen og menuen, medmindre der er en god grund

## Definition of done

- Funktionaliteten virker lokalt
- Eksisterende funktionalitet virker stadig
- Pull request henviser til issue
- Koden er reviewet før merge