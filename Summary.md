
Статус на 22.12.23

Реализованы:
    UI-тесты:
		
	- Оплата картой *4441 с валидными значениями
	- Покупка в кредит с картой *4441 с валидными значениями
	- Оплата картой *4442 с валидными значениями
	- Покупка в кредит с картой *4442 с валидными значениями
	
	- Оплата картой *4441 с невалидными значениями
	- Покупка в кредит с картой *4441 с невалидными значениями
	- Оплата картой *4442 с невалидными значениями
	- Покупка в кредит с картой *4442 с невалидными значениями

Не реализованы:
API-тесты:

	- проверка соединения с MySQL
	- проверка передачи данных и хранения в MySQL
	- проверка соединения с Postgres
	- проверка передачи данных и хранения в Postgres

Всего 22 теста, успешных - 16, неуспешных - 8. Тестирование проводилось по базам MySQL и PostreSQL в отдельности,
результаты тестирования идентичны по обеим базам.
Всего создано 7 баг-репортов. Один API-тест требует доработки.

ФАКТИЧЕСКАЯ ИНТЕРВАЛЬНАЯ ОЦЕНКА В ЧАСАХ В СРАВНЕНИИ С ПЛАНОВОЙ

	Подготовка программного окружения - 12 часов / 12 часов
	Написание автотестов - 24 часа / 34 часов
	Тестирование и отладка - 16 часов / 26 часов
	Создание и проверка отчетов - 8 часов / 16 часов
	
ФАКТИЧЕКИЙ ПЛАН СДАЧИ РАБОТ В СРАВНЕНИИ С ПЛАНОВЫМ
	
	Планирование - до 30.11.23 / до 30.11.23
	Автоматизация - 01.12.23 - 12.12.23 / 01.12.23 - 18.12.23
	Отчетность по автотестам - 13.12.23 - 14.12.23 / 18.12.23 - 20.12.23 
	Отчетность по автоматизации - с 14.12.23 по 15.12.23 / 20.12.23 - 22.12.23