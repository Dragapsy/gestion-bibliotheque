#  Projet Bibliothèque - Module JEE (ESGI M1)

Ce projet est une application backend développée en **Java / Spring Boot** dans le cadre du module JEE.

---

##  Objectif
Permettre de gérer :
- Les utilisateurs (`User`)
- Les livres (`Book`)
- Les emprunts (`Emprunt`)

---

## Technologies
- Java 21
- Spring Boot 3.5.0
- Spring Web / Spring Data JPA
- H2 Database
- Swagger (Springdoc OpenAPI)
- Maven

---

## Modèle de données

- `User` ➝ `id`, `nom`, `prenom`, `email`
- `Book` ➝ `id`, `titre`, `auteur`, `genre`
- `Emprunt` ➝ `id`, `dateEmprunt`, `user`, `book`

Relations :
- `User`  `Emprunt` : 1 ➝ N  
- `Book`  `Emprunt` : 1 ➝ N

---

##  Endpoints REST principaux

| Méthode | Endpoint              | Description              |
|--------|-----------------------|--------------------------|
| GET    | `/api/users`          | Liste des utilisateurs   |
| POST   | `/api/users`          | Créer un utilisateur     |
| GET    | `/api/books`          | Liste des livres         |
| POST   | `/api/books`          | Créer un livre           |
| GET    | `/api/emprunts`       | Liste des emprunts       |
| POST   | `/api/emprunts`       | Enregistrer un emprunt   |

---

##  Swagger UI
Accès à la documentation :
`http://localhost:8080/swagger-ui.html`

---

##  Lancer l'application

```bash
# 1. Cloner le projet
git clone https://github.com/<ton-nom-utilisateur>/<ton-repo>.git

# 2. Ouvrir dans IntelliJ ou VS Code

# 3. Lancer la classe principale :
# com.esgi.bibliotheque.BibliothequeApplication

# 4. Accéder à :
# http://localhost:8080/swagger-ui.html
