# Тестовое задание masterdata
**Задача:** Реализовать Rest API
Методы API:
1. Добавить продукт к производителю HTTP метод POST(если создается новый продукт)/PUT(если обновляется существующий) <br />
Пример запроса:<br />
URL: /addProduct<br />
Body:

| Имя параметра   | Тип    | Обязателен ли   |
| --------------- | ------ | --------------- |
| product_id      | String | обязательный    |
| manufacturer_id | String | обязательный    |
| product_name    | String | не обязательный |

2. Вывести все продукты производителя HTTP метод GET <br />
Пример запроса: <br />
URL: /getAllProducts?manufacturer_id=1234 <br />
Где manufacturer_id - уникальный идентификатор производителя <br />

3. Вывести названия всех производителей, у которых больше N продуктов HTTP метод GET <br />
URL: /getManufacturers?num=2 <br />
Где num - количество продуктов для выборки <br />
Модель данных:
Таблица **Product**

| Name            | Type   | Description     |
| --------------- | ------ | --------------- |
| product_id      | String | Id продукта     |
| manufacturer_id | String | Id производителя|
| product_name    | String | Имя продукта    |

Таблица **Manufacturer**

| Name            | Type   | Description     |
| --------------- | ------ | --------------- |
| manufacturer_id | String | Id производителя|
|manufacturer_name| String |Имя производителя|

