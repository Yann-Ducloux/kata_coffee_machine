# Explication du code du kata coffee machine
## Enum
- il y a un nombre limité de boissons.
- cela a été facile d'ajouter le prix de la boisson.
- facilement ajouter une nouvelle boisson.

## EnumMap
- facilement de compté le nombre de boissons commandé.
- si une nouvelle boisson est ajouté, c'est automatiquement pris en compte pour l'affichage du rapport.

## Clean code
- nom significatif pour chaque méthode, class et test.
- les fonctions sont le plus courte possible en les divisant en plusieurs méthodes.
- pour respecter le principe solid "S" en séparant au maximum les responsabilités.
- absence de magic number

## TDD
- J'ai développé en suivant le principe du TDD ainsi que du babyStep.
- couverture du code de 100%.

## Commit
- gitMoji pour avoir un code qui explique le commit au global.
- dans les messages de commit, je mets toujours un message qui explique le changement du code.

## Exception
- j'ai utilisé une exception personalisé car grace au try catch, je pourrais m'arrêter à l'exception.
- facilité d'afficher le message d'erreur.
- j'ai utilisé une classe checker pour séparer le contrôle effectué dans le code.

## DecimalFormat
- cela facilite l'affichage des nombres à chiffres après la virgule.

