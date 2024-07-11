# ForoHub - Challenge Back End

¡Bienvenido a mi último desafío Challenge Back End!

## Descripción del Proyecto

ForoHub es una API REST diseñada para replicar el funcionamiento de un foro, similar al que utilizan los estudiantes de Alura Latam para resolver sus dudas sobre cursos y proyectos. En este foro, los participantes pueden plantear preguntas sobre determinados tópicos y recibir respuestas de otros usuarios, incluyendo estudiantes, profesores y moderadores.

## Objetivo

El objetivo principal de este desafío es crear una API REST usando Spring que permita a los usuarios realizar operaciones CRUD (Crear, Consultar, Actualizar, Eliminar) en los tópicos del foro. Nuestra API se centrará específicamente en la gestión de estos tópicos.

## Funcionalidades

La API debe proporcionar las siguientes funcionalidades:

1. **Crear un nuevo tópico**: Permitir a los usuarios crear un nuevo tópico en el foro.
2. **Mostrar todos los tópicos creados**: Listar todos los tópicos existentes en el foro.
3. **Mostrar un tópico específico**: Obtener los detalles de un tópico específico mediante su ID.
4. **Actualizar un tópico**: Permitir a los usuarios actualizar la información de un tópico existente.
5. **Eliminar un tópico**: Permitir a los usuarios eliminar un tópico del foro.

## Requisitos

Para cumplir con los objetivos del proyecto, se implementarán las siguientes características:

- **Rutas REST**: La API seguirá las mejores prácticas del modelo REST para la implementación de rutas.
- **Validaciones**: Se realizarán validaciones según las reglas de negocio para asegurar la integridad de los datos.
- **Base de Datos Relacional**: Se utilizará una base de datos relacional para la persistencia de la información.
- **Autenticación y Autorización**: Se implementará un servicio de autenticación/autorización para restringir el acceso a la información sensible y asegurar que solo usuarios autorizados puedan realizar ciertas operaciones.

## Tecnologías Utilizadas

- **Spring Framework**: Para la creación de la API REST.
- **Base de Datos Relacional**: Para la persistencia de los datos.
- **JWT**: Para la autenticación y autorización de usuarios.
- **Hibernate**: Para la gestión de la base de datos.

## Instalación y Ejecución

Para ejecutar este proyecto localmente, sigue los siguientes pasos:

1. Clona este repositorio:
   ```bash
   git clone https://github.com/Jabesreyes/Foro-Hub.git
