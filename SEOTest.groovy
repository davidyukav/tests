package com.drom.productionTests

import groovy.com.drom.productionTests.FunctionalTest
import groovy.com.drom.productionTests.Http
import groovy.com.drom.productionTests.Utils
import groovy.com.drom.productionTests.SEO.SEOTemplates
import org.testng.annotations.DataProvider
import org.testng.annotations.Test

import static com.codeborne.selenide.Selenide.*
import static com.codeborne.selenide.Condition.*

class SEOTest extends FunctionalTest {

    static String[] userAgent = [
            //"Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)",
            //"Mozilla/5.0 (iPhone; CPU iPhone OS 8_3 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) CriOS/41.0.2272.58 Mobile/12F70 Safari/600.1.4 (000651) drom-production-test",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36"
    ]

    private String keywords = "авто, автомобили, форумы, автофорум, продажа б/у, пробег, подержанные, продажа авто, продажа автомобилей, отзывы, автовладельцы, объявления, цены, продажа, toyota, nissan, mitsubishi, honda, mazda, suzuki, subaru, audi, bmw, ford, opel, kia, hyundai, каталог"

    @DataProvider(name = "url", parallel = true)
    Object[][] getURL() {
        [
                [
                        'http://auto.drom.ru/'
                ],
                [
                        'http://auto.drom.ru/all/'
                ],
                [
                        'http://auto.drom.ru/lada/'
                ],
                [
                        'http://auto.drom.ru/lada/all/'
                ],
                [
                        'http://auto.drom.ru/region25/'
                ],
                [
                        'http://auto.drom.ru/region25/all/'
                ],
                [
                        'http://vladivostok.drom.ru/auto/'
                ],
                [
                        'http://vladivostok.drom.ru/auto/all/'
                ],
                [
                        'http://vladivostok.drom.ru/auto/?new'
                ],
                [
                        'http://auto.drom.ru/region25/?new'
                ],
                [
                        'http://auto.drom.ru/?new'
                ],
                [
                        'http://auto.drom.ru/lada/?new'
                ],
                [
                        'http://auto.drom.ru/region25/lada/priora/?new'
                ],
                [
                        'http://news.drom.ru/'
                ],
                [
                        'http://news.drom.ru/37894.html'
                ],
                [
                        'http://news.drom.ru/subaru/?all'
                ],
                [
                        'http://news.drom.ru/business_in_russia/'
                ],
                [
                        'http://news.drom.ru/world_car_business/'
                ],
                [
                        'http://news.drom.ru/sport/'
                ],
                [
                        'http://news.drom.ru/credit/'
                ],
                [
                        'http://news.drom.ru/crash-test/'
                ],
                [
                        'http://travel.drom.ru/'
                ],
                [
                        'http://travel.drom.ru/37804/'
                ],
                [
                        'http://pdd.drom.ru/'
                ],
                [
                        'http://pdd.drom.ru/bilet_3/'
                ],
                [
                        'http://pdd.drom.ru/themes/general/'
                ],
                [
                        'http://pdd.drom.ru/bilet_3/vopros_1/'
                ],
                [
                        'http://www.drom.ru/catalog/'
                ],
                [
                        'http://www.drom.ru/catalog/mitsubishi/'
                ],
                [
                        'http://www.drom.ru/catalog/mitsubishi/outlander/'
                ],
                [
                        'http://www.drom.ru/catalog/nissan/serena/g_1994_444/'
                ],
                [
                        'http://www.drom.ru/catalog/nissan/serena/37797/'
                ],
                [
                        'http://reviews.drom.ru/'
                ],
                [
                        'http://reviews.drom.ru/mazda/cx-5/93107/'
                ],
                [
                        'http://reviews.drom.ru/mazda/demio/'
                ],
                [
                        'http://reviews.drom.ru/mazda/demio/tag/foto/'
                ],
                [
                        'http://toyota.drom.ru/camry/'
                ],
                [
                        'http://novosibirsk.drom.ru/new/'
                ],
                [
                        'http://novosibirsk.drom.ru/new/hyundai/'
                ],
                [
                        'http://www.drom.ru/topcars/'
                ],
                [
                        'http://videoregistrator.drom.ru/'
                ],
                [
                        'http://videoregistrator.drom.ru/finevu/'
                ],
                [
                        'http://videoregistrator.drom.ru/finevu/cr-2000sblackedition/'
                ],
                [
                        'http://www.drom.ru/shina/'
                ],
                [
                        'http://www.drom.ru/shina/bridgestone/'
                ],
                [
                        'http://www.drom.ru/shina/bridgestone/blizzak_dm-v1/'
                ],
                [
                        'http://forums.drom.ru/'
                ],
                [
                        'http://forums.drom.ru/regions/'
                ],
                [
                        'http://forums.drom.ru/moscow/'
                ],
                [
                        'http://forums.drom.ru/kemerovo/t1151204361.html'
                ],
                [
                        'http://www.drom.ru/lada/vesta/#blog'
                ],
                [
                        'http://blogs.drom.ru/'
                ],
                [
                        'http://granta-sport.drom.ru/'
                ],
                [
                        'http://granta-sport.drom.ru/37570/'
                ],
                [
                        'http://mazda6.drom.ru/'
                ],
                [
                        'http://mazda6.drom.ru/37435/'
                ],
                [
                        'http://patriot.drom.ru/'
                ],
                [
                        'http://patriot.drom.ru/37672/'
                ],
                [
                        'http://rapid.drom.ru/'
                ],
                [
                        'http://rapid.drom.ru/37125/'
                ],
                [
                        'http://hover-h3.drom.ru/'
                ],
                [
                        'http://hover-h3.drom.ru/36937/'
                ],
                [
                        'http://info.drom.ru/'
                ],
                [
                        'http://info.drom.ru/misc/37066/'
                ],
                [
                        'http://info.drom.ru/nissan/'
                ],
                [
                        'http://info.drom.ru/nissan/cube/'
                ],
                [
                        'http://info.drom.ru/surveys/37757/'
                ],
                [
                        'http://info.drom.ru/surveys/great_wall/'
                ],
                [
                        'http://info.drom.ru/surveys/toyota/page45.html'
                ],
                [
                        'http://info.drom.ru/tuning/'
                ],
                [
                        'http://info.drom.ru/misc/'
                ],
                [
                        'http://www.drom.ru/customs/'
                ],
                [
                        'http://info.drom.ru/exp/volkswagen/'
                ],
                [
                        'http://info.drom.ru/surveys/30445/'
                ],
                [
                        'http://info.drom.ru/japan/'
                ],
                [
                        'http://info.drom.ru/pts/'
                ],
        ]
    }

    @Test(dataProvider = "url", enabled = false)
    void testMobileFriendlyGoogle(name, age){
        open "https://www.google.com/webmasters/tools/mobile-friendly/"

        $(".label-input-label").setValue(args)
        $("[role='button']").click()

        waitForAjaxToComplete()

        $(".mobile-friendly-banner").shouldHave(text("Отлично! Страница оптимизирована для мобильных устройств."))
    }

    @Test(dataProvider = "url", enabled = false)
    void testMobileFriendlyBing(args){
        open "https://www.bing.com/webmaster/tools/mobile-friendliness"

        $("#url-input-field").setValue(args)
        $("#url-input-button").click()

        waitForAjaxToComplete()

        $(".successGreen").shouldBe(visible)
    }

    @DataProvider(name = "SalesUrls", parallel = true)
    Object[][] getSalesUrls() {
        [
                [
                        'http://www.drom.ru/',
                        [
                                keywords: keywords,
                                description: "Автомобили и запчасти: продажа новых и б/у авто, каталог, отзывы автовладельцев, форумы, ремонт и эксплуатация, приключения, аукционы, спортивные машины, тюнинг, объявления и цены",
                                title: "Drom.ru - автомобильный портал",
                                h1: ""
                        ]
                ],
                [
                        'http://auto.drom.ru/',
                        [
                                h1: "Продажа автомобилей в России",
                                title: "Продажа автомобилей в России. Подержанные авто, новые. Купить автомобиль б/у, цены.",
                                description: "Объявления о продаже автомобилей. Продажа подержанных авто и новых. Автосалоны и частные объявления",
                                keywords: "автомобили, авто, объявления, б.у. авто, автосалоны, авторынки, продажа авто, продажа автомобилей, продажа подержанных автомобилей, купить автомобиль, подержанные автомобили"
                        ]
                ],
                [
                        'http://auto.drom.ru/all/',
                        [
                                h1: "Продажа автомобилей в России",
                                title: "Продажа подержанных автомобилей, новых и авто с пробегом. Купить авто б/у.",
                                description: "Объявления о продаже подержанных автомобилей. Продажа б.у. авто и новых. Автосалоны и частные объявления",
                                keywords: "автомобили, авто, объявления, б.у. авто, автосалоны, авторынки, продажа авто, продажа автомобилей, продажа подержанных автомобилей, купить авто, подержанные авто"
                        ]
                ],
                [
                        'http://auto.drom.ru/lada/',
                        [
                                h1: "Продажа Лада (ВАЗ) в России",
                                title: "Продажа Лада  (ВАЗ) в России",
                                description: "Частные объявления о продаже Лада в России - на Drom.ru",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://auto.drom.ru/lada/all/',
                        [
                                h1: 'Продажа Лада (ВАЗ) в России',
                                title: "Продажа Лада  (ВАЗ) в России",
                                description: "Частные объявления о продаже Лада  в России - на Drom.ru",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/',
                        [
                                h1: "Продажа автомобилей в Приморском крае",
                                title: "Продажа  автомобилей в Приморском крае",
                                description: "Частные объявления о продаже автомобилей на Drom.ru во Владивостоке",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/all/',
                        [
                                h1: "Продажа автомобилей в Приморском крае",
                                title: "Продажа  автомобилей в Приморском крае",
                                description: "Частные объявления о продаже автомобилей во Владивостоке",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/lada/',
                        [
                                h1: 'Продажа Лада (ВАЗ) в Приморском крае',
                                title: "Продажа Лада  (ВАЗ) в Приморском крае",
                                description: "Частные объявления о продаже Лада во Владивостоке",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/lada/all/',
                        [
                                h1: "Продажа Лада (ВАЗ) в Приморском крае",
                                title: "Продажа Лада  (ВАЗ) в Приморском крае",
                                description: "Частные объявления о продаже Лада  во Владивостоке",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/auto/',
                        [
                                h1: "Продажа автомобилей во Владивостоке",
                                title: "Продажа автомобилей во Владивостоке, новые и подержанные автомобили. Авторынок Владивосток. Купить автомобиль б/у, цены.",
                                description: "Объявления о продаже автомобилей во Владивостоке. Продажа авто б/у и новых, частные объявления, авторынки и автосалоны Владивостока.",
                                keywords: "авто, автомобили, объявления, авто б.у., автосалоны, авторынки, авторынок Владивосток, продажа авто, продажа автомобилей, авто Владивосток, купить авто, подержанные авто, Владивосток"
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/auto/all/',
                        [
                                h1: "Продажа автомобилей во Владивостоке",
                                title: "Продажа подержанных автомобилей во Владивостоке, новых и авто с пробегом. Купить автомобиль б/у Владивосток.",
                                description: "Объявления о продаже авто во Владивостоке. Продажа подержанных автомобилей и новых. Автосалоны, авторынки и частные объявления Владивостока.",
                                keywords: "автомобили, авто, объявления, авто б.у., автосалоны, авторынки, авторынок Владивосток, продажа авто, продажа подержанных автомобилей, автомобили во Владивостоке, купить автомобиль, подержанные автомобили, Владивосток"
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/lada/all/',
                        [
                                h1: "Продажа Лада (ВАЗ) во Владивостоке",
                                title: "Продажа Лада  (ВАЗ) во Владивостоке",
                                description: "Частные объявления о продаже Лада  во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/lada/priora/',
                        [
                                h1: "Продажа Лада Приора во Владивостоке",
                                title: "Продажа Лада Приора во Владивостоке",
                                description: "Частные объявления о продаже Лада Приора во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/auto/?new',
                        [
                                h1: "Продажа новых автомобилей во Владивостоке",
                                title: "Продажа новых  автомобилей во Владивостоке",
                                description: "Частные объявления о продаже автомобилей на Drom.ru во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/?new',
                        [
                                h1: "Продажа новых автомобилей в Приморском крае",
                                title: "Продажа новых  автомобилей в Приморском крае",
                                description: "Частные объявления о продаже автомобилей на Drom.ru во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/?new',
                        [
                                h1: "Продажа новых автомобилей в России",
                                title: "Продажа новых  автомобилей в России",
                                description: "Частные объявления о продаже автомобилей на Drom.ru в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/lada/?new',
                        [
                                h1: "Продажа новых Лада (ВАЗ) в России",
                                title: "Продажа новых Лада  (ВАЗ) в России",
                                description: "Частные объявления о продаже Лада в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/lada/all/?new',
                        [
                                h1: "Продажа новых Лада (ВАЗ) в России",
                                title: "Продажа новых Лада  (ВАЗ) в России",
                                description: "Частные объявления о продаже Лада  в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/lada/priora/?new',
                        [
                                h1: 'Продажа новых Лада Приора в России',
                                title: "Продажа новых Лада Приора в России",
                                description: "Частные объявления о продаже Лада Приора в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/lada/priora/?new',
                        [
                                h1: "Продажа новых Лада Приора в Приморском крае",
                                title: "Продажа новых Лада Приора в Приморском крае",
                                description: "Частные объявления о продаже Лада Приора во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/lada/priora/?new',
                        [
                                h1: "Продажа новых Лада Приора во Владивостоке",
                                title: "Продажа новых Лада Приора во Владивостоке",
                                description: "Частные объявления о продаже Лада Приора во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/toyota/',
                        [
                                h1: "Продажа Toyota (Тойота) в России",
                                title: "Продажа Toyota  (Тойота) в России",
                                description: "Частные объявления о продаже Toyota в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/toyota/camry/',
                        [
                                h1: "Продажа Toyota Camry (Тойота Камри) в России",
                                title: "Продажа Toyota Camry (Тойота Камри) в России",
                                description: "Частные объявления о продаже Toyota Camry в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/toyota/',
                        [
                                h1: "Продажа Toyota в Приморском крае",
                                title: "Продажа Toyota  в Приморском крае",
                                description: "Частные объявления о продаже Toyota во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/toyota/all/',
                        [
                                h1: "Продажа Toyota в Приморском крае",
                                title: "Продажа Toyota  в Приморском крае",
                                description: "Частные объявления о продаже Toyota  во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/toyota/camry/',
                        [
                                h1: "Продажа Toyota Camry в Приморском крае",
                                title: "Продажа Toyota Camry в Приморском крае",
                                description: "Частные объявления о продаже Toyota Camry во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/toyota/all/',
                        [
                                h1: "Продажа Toyota во Владивостоке",
                                title: "Продажа Toyota  во Владивостоке",
                                description: "Частные объявления о продаже Toyota  во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/toyota/camry/',
                        [
                                h1: "Продажа Toyota Camry во Владивостоке",
                                title: "Продажа Toyota Camry во Владивостоке",
                                description: "Частные объявления о продаже Toyota Camry во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/toyota/?new',
                        [
                                h1: "Продажа новых Toyota (Тойота) в России",
                                title: "Продажа новых Toyota  (Тойота) в России",
                                description: "Частные объявления о продаже Toyota в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/toyota/all/?new',
                        [
                                h1: "Продажа новых Toyota (Тойота) в России",
                                title: "Продажа новых Toyota  (Тойота) в России",
                                description: "Частные объявления о продаже Toyota  в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/toyota/camry/?new',
                        [
                                h1: "Продажа новых Toyota Camry (Тойота Камри) в России",
                                title: "Продажа новых Toyota Camry (Тойота Камри) в России",
                                description: "Частные объявления о продаже Toyota Camry в России - на Drom.ru",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/toyota/camry/?new',
                        [
                                h1: "Продажа новых Toyota Camry в Приморском крае",
                                title: "Продажа новых Toyota Camry в Приморском крае",
                                description: "Частные объявления о продаже Toyota Camry во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://vladivostok.drom.ru/toyota/camry/?new',
                        [
                                h1: "Продажа новых Toyota Camry во Владивостоке",
                                title: "Продажа новых Toyota Camry во Владивостоке",
                                description: "Частные объявления о продаже Toyota Camry во Владивостоке",
                                keywords: keywords
                        ]
                ],
                [
                        'http://auto.drom.ru/lada/priora/',
                        [
                                h1: "Продажа Лада Приора в России",
                                title: "Продажа Лада Приора в России",
                                description: "Частные объявления о продаже Лада Приора в России - на Drom.ru",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://auto.drom.ru/region25/lada/priora/',
                        [
                                h1: "Продажа Лада Приора в Приморском крае",
                                title: "Продажа Лада Приора в Приморском крае",
                                description: "Частные объявления о продаже Лада Приора во Владивостоке",
                                keywords: keywords,
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/audi/q7/',
                        [
                                h1: 'Отзывы владельцев Audi Q7 (Ауди Ку7) с ФОТО',
                                title: 'Отзывы владельцев Audi Q7 (Ауди Ку7) с ФОТО',
                                description: 'Отзывы владельцев Audi Q7. Надежность Ауди Ку7. Достоинства и недостатки Audi Q7. Опыт эксплуатации автомобилей Ауди Ку7.',
                                keywords: 'отзывы Audi Q7, отзывы владельцев Audi Q7, Audi Q7, Ауди Ку7, Audi Q7 фото, надежность Q7, недостатки Ку7, эксплуатация Audi Q7'
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/lada/xray/',
                        [
                                h1: 'Отзывы владельцев Лада Х-рей (ВАЗ XRAY) с ФОТО',
                                title: 'Отзывы владельцев Лада Х-рей (ВАЗ XRAY) с ФОТО',
                                description: 'Отзывы владельцев Лада Х-рей. Надежность ВАЗ XRAY. Достоинства и недостатки Лада Х-рей. Опыт эксплуатации автомобилей ВАЗ XRAY.',
                                keywords: 'отзывы Лада Х-рей, отзывы владельцев Лада Х-рей, Лада Х-рей, ВАЗ XRAY, Лада Х-рей фото, надежность Х-рей, недостатки XRAY, эксплуатация Лада Х-рей'
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/lada/vesta/',
                        [
                                h1: 'Отзывы владельцев Лада Веста с ФОТО',
                                title: 'Отзывы владельцев Лада Веста с ФОТО',
                                description: 'Отзывы владельцев Лада Веста. Надежность ВАЗ. Достоинства и недостатки Лада Веста. Опыт эксплуатации автомобилей ВАЗ.',
                                keywords: 'отзывы Лада Веста, отзывы владельцев Лада Веста, Лада Веста, ВАЗ, Лада Веста фото, надежность Веста, недостатки ВАЗ, эксплуатация Лада Веста'
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/audi/',
                        [
                                h1: 'Отзывы владельцев Audi с ФОТО',
                                title: 'Отзывы владельцев Audi с ФОТО',
                                description: 'Отзывы владельцев Audi',
                                keywords: 'отзывы, Audi, японские, машины , Ауди'
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/audi/q7/?order=rate',
                        [
                                h1: 'Популярные отзывы владельцев Audi Q7 (Ауди Ку7) с ФОТО',
                                title: 'Популярные отзывы владельцев Audi Q7 (Ауди Ку7) с ФОТО',
                                description: 'Популярные отзывы владельцев Audi Q7. Надежность Ауди Ку7. Достоинства и недостатки Audi Q7. Опыт эксплуатации автомобилей Ауди Ку7.',
                                keywords: 'популярные отзывы Audi Q7, популярные отзывы владельцев Audi Q7, Audi Q7, Ауди Ку7, Audi Q7 фото, надежность Q7, недостатки Ку7, эксплуатация Audi Q7'
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/toyota/all/?year1=1994&year2=2000&volume1=1.3&volume2=3.5&fueltype=1&transmission=1&privod=1',
                        [
                                title: 'Отзывы владельцев Toyota  1.3 - 3.5 л., 1994 - 2000 год, бензин, коробка, передний привод с ФОТО',
                                h1: 'Отзывы владельцев Toyota 1.3 - 3.5 л., 1994 - 2000 год, бензин, коробка, передний привод с ФОТО',
                                description: 'Отзывы владельцев Toyota. Надежность Тойота. Достоинства и недостатки Toyota. Опыт эксплуатации автомобилей Тойота.',
                                keywords: 'отзывы Toyota, отзывы владельцев Toyota, Toyota, Тойота, Toyota фото, надежность Toyota, недостатки Тойота, эксплуатация Toyota',
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/sedan/toyota/?year1=1994&year2=2000&volume1=1.3&volume2=3.5&fueltype=1&transmission=1&privod=1',
                        [
                                title: 'Отзывы владельцев седанов Toyota 1.3 - 3.5 л., 1994 - 2000 год, бензин, коробка, передний привод',
                                h1: 'Отзывы владельцев седанов Toyota 1.3 - 3.5 л., 1994 - 2000 год, бензин, коробка, передний привод',
                                description: 'Автомобили и запчасти: продажа новых и б/у авто, каталог, отзывы автовладельцев, форумы, ремонт и эксплуатация, приключения, аукционы, спортивные машины, тюнинг, объявления и цены',
                                keywords: 'авто, автомобили, форумы, автофорум, продажа б/у, пробег, подержанные, продажа авто, продажа автомобилей, отзывы, автовладельцы, объявления, цены, продажа, toyota, nissan, mitsubishi, honda, mazda, suzuki, subaru, audi, bmw, ford, opel, kia, hyundai, каталог',
                        ]
                ],
                //Проблема с дескрипшионом
                /*[
                        'http://www.drom.ru/reviews/suv/toyota/land_cruiser/?year1=1999&transmission=1&privod=3',
                        [
                                title: 'Отзывы владельцев SUV\'ов Toyota Land Cruiser (Тойота Ленд Крузер) от 1999 года, коробка, полный привод',
                                h1: 'Отзывы владельцев SUV\'ов Toyota Land Cruiser (Тойота Ленд Крузер) от 1999 года, коробка, полный привод',
                                description: '',
                                keywords: 'отзывы, SUV, Toyota, Land Cruiser, японские, машины  (Тойота Ленд Крузер)',
                        ]
                ],*/
                [
                        'http://www.drom.ru/reviews/sedan/bmw/5-series/?year1=2014&year2=2015&volume1=1.6&volume2=2.7&fueltype=1&transmission=1&privod=1',
                        [
                                title: 'Отзывы владельцев седанов BMW 5-Series (БМВ 5 серии) 1.6 - 2.7 л., 2014 - 2015 год, бензин, коробка, передний привод',
                                h1: 'Отзывы владельцев седанов BMW 5-Series (БМВ 5 серии) 1.6 - 2.7 л., 2014 - 2015 год, бензин, коробка, передний привод',
                                description: 'Отзывы владельцев седанов BMW 5-Series (БМВ 5 серии)',
                                keywords: 'отзывы, Седаны, BMW, 5-Series, японские, машины  (БМВ 5 серии)',
                        ]

                ],
                [
                        'http://www.drom.ru/reviews/toyota/crown/5kopeek/?year1=2015&volume1=1.5&order=rate',
                        [
                                title: '5 копеек о Toyota Crown (Тойота Краун) от 1.5 л., от 2015 года',
                                h1: '5 копеек о Toyota Crown (Тойота Краун) от 1.5 л., от 2015 года - мнения владельцев',
                                description: 'Тысячи мнений о недостатках и преимуществ автомобилей',
                                keywords: 'мнения, владельцев, об автомобилях, владельцев автомобилей',
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/sedan/audi/q7/?volume2=1.5',
                        [
                                title: 'Отзывы владельцев седанов Audi Q7 (Ауди Ку7) до 1.5 л.',
                                h1: 'Отзывы владельцев седанов Audi Q7 (Ауди Ку7) до 1.5 л.',
                                description: 'Отзывы владельцев седанов Audi Q7 (Ауди Ку7)',
                                keywords: 'отзывы, Седаны, Audi, Q7, японские, машины  (Ауди Ку7)',
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/toyota/crown_majesta/?year2=1999&volume1=2.5&volume2=2.5&fueltype=1&transmission=1&privod=3',
                        [
                                title: 'Отзывы владельцев Toyota Crown Majesta (Тойота Краун Маджеста) 2.5 л., до 1999 года, бензин, коробка, полный привод с ФОТО',
                                h1: 'Отзывы владельцев Toyota Crown Majesta (Тойота Краун Маджеста) 2.5 л., до 1999 года, бензин, коробка, полный привод с ФОТО',
                                description: 'Отзывы владельцев Toyota Crown Majesta. Надежность Тойота Краун Маджеста. Достоинства и недостатки Toyota Crown Majesta. Опыт эксплуатации автомобилей Тойота Краун Маджеста.',
                                keywords: 'отзывы Toyota Crown Majesta, отзывы владельцев Toyota Crown Majesta, Toyota Crown Majesta, Тойота Краун Маджеста, Toyota Crown Majesta фото, надежность Crown Majesta, недостатки Краун Маджеста, эксплуатация Toyota Crown Majesta',
                        ]
                ],
                [
                        'http://www.drom.ru/reviews/sedan/toyota/avensis_verso/?year1=2016&privod=3',
                        [
                                title: 'Отзывы владельцев седанов Toyota Avensis Verso (Тойота Авенсис Версо) от 2016 года, полный привод',
                                h1: 'Отзывы владельцев седанов Toyota Avensis Verso (Тойота Авенсис Версо) от 2016 года, полный привод',
                                description: 'Отзывы владельцев седанов Toyota Avensis Verso (Тойота Авенсис Версо)',
                                keywords: 'отзывы, Седаны, Toyota, Avensis Verso, японские, машины  (Тойота Авенсис Версо)',
                        ]
                ],
        ]
    }

    @Test(dataProvider = "SalesUrls")
    void testCheckSEOMeta(url, template){
        def html = new SEOTemplates([url: url, followRedirects: false, responseCode: 200])
        template.each {
                assert html["${it.key}"] == it.value, "${it.key} expected value is ${it.value}\n${it.key} actual value is ${html["${it.key}"]}\nurl is $url "
        }
    }

    @DataProvider(name = "SharingMetaUrls", parallel = true)
    Object[][] getUrls(){
        [
                [
                        'http://www.drom.ru/reviews/mercedes-benz/e-class/159346/',
                        [
                                'og:description': 'Отзыв владельца Mercedes-Benz E-Class 2007: Машина была куплена не в самом лучшем состоянии, 170 л.с., автоматическая коробка передач, Приморье, задний привод, дизель, 2.2л., Владивосток',
                                'og:title' : 'Мерседес Е-класс 2007 — отзыв владельца',
                                'og:url' : 'http://www.drom.ru/reviews/mercedes-benz/e-class/159346/',
                                'twitter:card' : 'summary_large_image',
                                'twitter:title' : 'Мерседес Е-класс 2007 — отзыв владельца',
                                'twitter:description' : 'Отзыв владельца Mercedes-Benz E-Class 2007: Машина была куплена не в самом лучшем состоянии, 170 л.с., автоматическая коробка передач, Приморье, задний привод, дизель, 2.2л., Владивосток',
                                'twitter:site' : '@dromru',
                                'twitter:creator' : '@dromru',
                                'twitter:url' : 'http://www.drom.ru/reviews/mercedes-benz/e-class/159346/',
                                'relap-title' : 'Мерседес Е-класс 2007 — отзыв владельца',
                                'relap-description' : 'Отзыв владельца Mercedes-Benz E-Class 2007: Машина была куплена не в самом лучшем состоянии, 170 л.с., автоматическая коробка передач, Приморье, задний привод, дизель, 2.2л., Владивосток',
                                'relap-image' : 'http://s.auto.drom.ru/i24203/r/photos/159346/1113466.jpg',
                                'twitter:image' : 'http://s.auto.drom.ru/i24203/r/photos/159346/1113466.jpg',
                                'og:image' : 'http://s.auto.drom.ru/i24203/r/photos/159346/1113466.jpg',
                                'og:type': 'article',
                                'og:site_name' : 'Drom.ru',
                                'author' : ''
                        ]
                        ],
                [
                        'http://www.drom.ru/reviews/nissan/wingroad/88990/117106/',
                        [
                                'og:description': 'Дополнение к отзыву владельца Nissan Wingroad 2003: Запуск в -34°С, Всем привет, бензин, 1.5 литра, расход ещё не определил, Эксплуатация, автомат, передний привод',
                                'og:title' : 'Запуск в -34°С, отзыв о Nissan Wingroad 2003',
                                'og:url' : 'http://www.drom.ru/reviews/nissan/wingroad/88990/117106/',
                                'twitter:card' : 'summary_large_image',
                                'twitter:title' : 'Запуск в -34°С, отзыв о Nissan Wingroad 2003',
                                'twitter:description' : 'Дополнение к отзыву владельца Nissan Wingroad 2003: Запуск в -34°С, Всем привет, бензин, 1.5 литра, расход ещё не определил, Эксплуатация, автомат, передний привод',
                                'twitter:site' : '@dromru',
                                'twitter:creator' : '@dromru',
                                'twitter:url' : 'http://www.drom.ru/reviews/nissan/wingroad/88990/117106/',
                                'relap-title' : 'Запуск в -34°С, отзыв о Nissan Wingroad 2003',
                                'relap-description' : 'Дополнение к отзыву владельца Nissan Wingroad 2003: Запуск в -34°С, Всем привет, бензин, 1.5 литра, расход ещё не определил, Эксплуатация, автомат, передний привод',
                                'relap-image' : 'http://s.auto.drom.ru/i24205/r/photos/88990/1133070.jpg',
                                'twitter:image' : 'http://s.auto.drom.ru/i24205/r/photos/88990/1133070.jpg',
                                'og:image' : 'http://s.auto.drom.ru/i24205/r/photos/88990/1133070.jpg',
                                'og:type': 'article',
                                'og:site_name' : 'Drom.ru',
                                'author' : 'Юрий V.',
                        ]
                ],
        ]
    }

    @Test(dataProvider = "SharingMetaUrls")
    void testSharingMeta(url, Map property){
         Map response = [:]
         def result = Http.connect(url: url)
             assert result.statusCode() == 200
             def properties = result.parse().select("meta[property]")

             for (int i=0;i<properties.size();i++){
                 response.put(properties[i].attr("property"), properties[i].attr("content"))
             }
         assert response.sort() == property.sort()
    }

    @Test
    void testUrlGetCanonicalInHeader(){
        def result = Http.connect(url: 'http://s.drom.ru/1/reviews/resized_tn/226x/11107_tn.jpg?up=1459902851', followRedirects: false)

        assert result.statusCode() == 200
        result.hasHeaderWithValue("Link", '<http://s.drom.ru/1/reviews/resized_tn/226x/11107_tn.jpg>; rel="canonical"')
    }


    @DataProvider(name = "canonical", parallel = true)
    Object[][] getUrl(){
        [
                [
                        'http://www.drom.ru/reviews/nissan/leaf/164048/?cd=desktop',
                ],
                [
                        'http://www.drom.ru/reviews/toyota/rav4/tag/live/',
                ],
                [
                        'http://www.drom.ru/reviews/infiniti/fx35/91903/114473/?cd=desktop',
                ],
                [
                        'http://www.drom.ru/reviews/hyundai/accent/',
                ],
                [
                        'http://www.drom.ru/reviews/hyundai/',
                ],
        ]
    }

    @Test(dataProvider = "canonical")
    void testURLCanonical(arg){
        def result = Http.connect(url: arg)

        String url
        if (arg.contains("?")){
            url = arg.substring(0, arg.indexOf("?"))
        }else{
            url = arg
        }

        assert result.url().toString() == url
        assert result.parse().select("link[rel='canonical']").attr("href") == url
    }

    @DataProvider(name = "nocanonical", parallel = true)
    Object[][] getNoCanonical(){
        [
                [
                        'http://www.drom.ru/reviews/hyundai/accent/?year1=2005'
                ],
                [
                        'http://www.drom.ru/reviews/toyota/rav4/tag/live/page6.html'
                ]
        ]
    }

    @Test(dataProvider = "nocanonical")
    void testURLNoCanonical(arg){
        def result = Http.connect(url: arg).parse()

        assert result.select("link[rel='canonical']").isEmpty()
    }

    @Test
    void testSitemapIsExist() {
        def result = Http.connect(url: 'http://www.drom.ru/sitemaps/catalog/generated/index.xml', followRedirects: false)

        Utils.CheckResnonseCodeAndContentType(result, 'text/xml')
    }

    @Test
    void testCheckRobotExist(){
        def result = Http.connect(url: 'http://auto.drom.ru/robot.txt', followRedirects: false)

        assert result.statusCode() == 301
        assert result.statusMessage() == 'Moved Permanently'
    }

    @DataProvider(name = "noindex", parallel = true)
    Object[][] getNoIndex(){
          [
                 [
                         'http://www.drom.ru/reviews/all/page10.html?year1=1994&year2=2000&volume1=1.3&volume2=3.5&fueltype=1&transmission=1&privod=1#tabs'
                 ],
                 [
                         'http://auto.drom.ru/stats/19232697/'
                 ]
          ]
    }

    @Test(dataProvider = "noindex")
    void testURLNoIndex(arg){
        def result = Http.connect(url: arg).parse()
        assert result.select("meta[name='robots']").attr("content") == "noindex, follow"
    }

}
