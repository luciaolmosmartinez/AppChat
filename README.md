# AppChat

**Nombre de aplicación:** AppChat

**Profesor responsable:** Francisco Javier Bermúdez Ruiz

**Componentes del grupo:**
1. Ana Martínez García
2. Lucía Olmos Martínez

**Breve descripción:**  
El propósito de esta aplicación es ofrecer un servicio de mensajería instantánea que permita a los usuarios comunicarse de forma sencilla mediante conversaciones individuales y grupales. Además del envío y recepción de mensajes, la aplicación incorpora funcionalidades para gestionar contactos, buscar conversaciones mediante filtros y exportar el historial de los chats.

La **funcionalidad extra** consiste en la **exportación del historial de una conversación a un documento PDF**, permitiendo al usuario guardar o compartir el contenido de un chat. Esta funcionalidad se encuentra implementada en la clase:

`AppChat_final/src/main/java/um/tds/Modelado/CreadorPDF.java`

Los **casos de uso** se encuentran documentados en los *Issues* del repositorio de GitHub.

El **modelado** del proyecto también puede consultarse en los *Issues* correspondientes del repositorio.

El **diseño de las ventanas** se encuentra igualmente documentado en los *Issues* dedicados a la interfaz gráfica.

## Ejecución de la aplicación

Para utilizar la aplicación, basta con abrir el proyecto en Eclipse y ejecutar la clase **Aplicacion**, localizada en:

`AppChat_final/src/main/java/um/tds/Main/Aplicacion.java`

Automáticamente se cargarán algunos usuarios de prueba mediante la clase **DataLoader**, lo que permitirá iniciar sesión sin necesidad de registrar nuevos usuarios.

Algunas credenciales disponibles son:

| Usuario (Teléfono) | Contraseña |
|--------------------|------------|
| 987654321 | a |
| 123456789 | l |
| 012345678 | l |
| 876543210 | a |
