## Task
Imagine, that we have beneficiary model:
id: autoincrement
uniq_code: varchar
name: varchar

Requirements:
Your goal is to create simple CRUD administration part for this module (could be in memory or h2 database). One of important scope for this task is possibility to show QR code.
Do not create front-end.
All you need to know is that any front application calls your queries and displays a QR code to any scanners. When scanner scan QR code the beneficiary information (uniq_code and name) appears. You are free to create endpoint and response instructions for front-end applications.
Helpful:
To generate QR code for this task we recommend to use free https://qrcode.tec-it.com/en (not required authorizations). You could choose other providers if you want.
Important:
1.	CRUD
2.	RESTful
3.	Clean OO/FP wise
4.	Covered by tests
Less important:
1.	Security
2.	Swagger


## Swagger
http://localhost:8080/v2/api-docs
http://localhost:8080/swagger-ui.html

## QR code front-end

To get qr code with data from DB send request to
http://localhost:8080/api/v1/qrcode/{id}
result put into img tag src property
<img src="URL FROM REST API" />
