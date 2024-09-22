# Процедура запуска авто-тестов:

1. Склонировать репозиторий
2. Открыть проект в Android Studio.
3. Запустить эмулятор (API 29).
4. Во вкладке Project выделить каталог app.
5. Запустить тесты:во вкладке Run нажать: Run 'Tests in 'ru.iteco.fmhandroid.ui.tests" .
6. По завершению, выгрузите каталог /data/data/ru.iteco.fmhandroid/files/allure-results с эмулятора (при помощи Device Explorer) в корень директории проекта. 
7. Выполните в терминале команду allure serve, находясь на уровень выше каталога allure-results.