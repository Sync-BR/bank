# API BANK

## Descrição
API desenvolvida para explorar conhecimentos e entender como funciona a criação de contas e autenticação de usuários com token.

---

## Endpoints

### **1. Criação de Conta**

- **URL**: `/api/user/controlador/creater`
- **Método**: `POST`
- **Descrição**: Cria uma nova conta de cliente e armazena seus dados, incluindo as informações de login.
- **Request Body**:
    ```json
    {
        "name": "string",
        "cpf": "string",
        "age": "int",
        "email": "string",
        "telephone": "string",
        "cep": "string",
        "houseNumber": "int",
        "houseLetter": "char",
        "sex": "Masculino/Feminino",
        "photo": "string",
        "login": {
            "username": "string",
            "password": "string"
        }
    }
    ```
- **Response**:
    - **201 Created**: Retorna os dados do cliente cadastrado.
    - **400 Bad Request**: Retorna uma mensagem de erro caso algum campo obrigatório esteja faltando ou inválido.

### **2. Autenticação de Usuário**

- **URL**: `/api/auth/login`
- **Método**: `POST`
- **Descrição**: Autentica o usuário e gera um token JWT para futuras requisições.
- **Request Body**:
    ```json
    {
        "username": "string",
        "password": "string"
    }
    ```
- **Response**:
    - **200 OK**: Retorna o token JWT para autenticação.
    - **401 Unauthorized**: Credenciais inválidas.

### **3. Obter Dados do Cliente**

- **URL**: `/api/cliente/{id}`
- **Método**: `GET`
- **Descrição**: Retorna os dados do cliente com base no ID especificado.
- **Headers**:
    - `Authorization`: `Bearer <token>`
- **Response**:
    - **200 OK**: Dados do cliente.
    - **404 Not Found**: Cliente não encontrado.
    - **401 Unauthorized**: Token inválido ou expirado.

---

## Modelos de Dados

### ClienteModel

| Campo           | Tipo        | Descrição                        |
|-----------------|-------------|----------------------------------|
| `id`            | int         | Identificador único do cliente.  |
| `name`          | string      | Nome completo do cliente.        |
| `cpf`           | string      | CPF do cliente (único).          |
| `age`           | int         | Idade do cliente.                |
| `email`         | string      | Email do cliente (único).        |
| `telephone`     | string      | Telefone do cliente.             |
| `cep`           | string      | CEP do cliente.                  |
| `houseNumber`   | int         | Número da casa do cliente.       |
| `houseLetter`   | char        | Letra do endereço (se aplicável).|
| `sex`           | enum        | Gênero (`Masculino` ou `Feminino`).|
| `photo`         | string      | Caminho para a foto do cliente.  |
| `login`         | LoginModel  | Objeto de login associado.       |

### LoginModel

| Campo           | Tipo        | Descrição                        |
|-----------------|-------------|----------------------------------|
| `id`            | int         | Identificador único de login.    |
| `username`      | string      | Nome de usuário (único).         |
| `password`      | string      | Senha do usuário.                |

---

## Autenticação

Esta API utiliza autenticação via JWT (JSON Web Token). Ao autenticar, o cliente deve enviar o token em cada requisição através do cabeçalho `Authorization` no formato `Bearer <token>`.

---

## Exemplo de Requisição

### Exemplo de criação de cliente

```http
POST /api/cliente
Content-Type: application/json

{
    "name": "Eduardo Freitas",
    "cpf": "12345678901",
    "age": 26,
    "email": "eduardofreitas@gmail.com",
    "telephone": "(71) 98357-9082",
    "cep": "40484550",
    "houseNumber": 89,
    "houseLetter": "A",
    "sex": "Masculino",
    "photo": "caminho/para/foto.jpg",
    "login": {
        "username": "eduardo123",
        "password": "senhaSegura123"
    }
}
