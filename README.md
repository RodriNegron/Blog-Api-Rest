# Blog-Api-Rest
Java / Spring-boot Api Rest JWT auth

# Endpoints

- POST /user

Sign Up:

email & password is required

---

- POST /auth/login

Log In:

generate Token by credentials

---

- POST /posts

New post:

generate new post

title, content and image fields required

---

- GET /posts

List all:

get all posts

---

- GET /posts/id

Get one post:

get post specified by id

---

- GET /user/id

Get one user:

get user specified by id

---

- PUT /posts/1

Delete one:

soft delete specific post, setting "active" attribute to false

