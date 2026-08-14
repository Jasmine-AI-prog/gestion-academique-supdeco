# Gestion Académique — Supdeco Dakar

Application Spring Boot MVC + REST pour gérer étudiants, cours, inscriptions et notes.

## Lancer

Prérequis : Java 17 et Maven 3.9+.

```text
mvn spring-boot:run
```

Puis ouvrir http://localhost:8081. Comptes de démonstration : `admin/admin123` (ADMIN) et `enseignant/enseignant123` (ENSEIGNANT).

- API REST : http://localhost:8081/api
- Swagger : http://localhost:8081/swagger-ui.html
- Console H2 : http://localhost:8081/h2-console (URL JDBC `jdbc:h2:file:./data/academique`)
- Données SQL de démonstration : [database/schema.sql](database/schema.sql)

## Architecture

`model` contient les entités JPA, `repository` les accès aux données, `service` la logique métier, `web` les contrôleurs Thymeleaf et `api` les contrôleurs REST.

## Le script SQL est ici :

`schema.sql`
Il contient :

la création des tables
les clés étrangères
les données de test
les exemples d’étudiants, cours, inscriptions et notes
