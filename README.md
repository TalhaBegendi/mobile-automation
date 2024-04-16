# Hepsiburada Test Otomasyonu UI

Bu README dosyası, Hepsiburada'nın Mobile test otomasyonu projesi için gerekli bilgileri içermektedir. Kullanıcıları bilgilendirmek amacıyla aşağıdaki adımlar ve talimatlar sunulmuştur.

## Kurulum

* Proje Java(Intellij)-Appium üzerinde geliştirilmiştir ve kullanılmak üzere tasarlanmıştır.
* Intellij'den projeyi import etmelisiniz.
* İlgili plugin kurulumları yapılmalıdır. Import ettikten sonra Intellij'de sağ alt tarafta ilgili pop-up da "configure plugin" tıklayıp pluginler yüklenebilir. (Cucumber, lambda v.b)
* SDK seçimi yapılmalıdır. SDK 17 seçilebilir.

## Kullanım

1. **Senaryoları Çalıştırma:**
   * `src/test/resources/features/HbScenarios.feature` dosyası açılır.
   * Tüm senaryoları çalıştırmak için, 1. satırdaki "Feature: Hepsiburada Mobile Scenarios" yanındaki "run" butonu kullanılabilir.
   * Tek bir senaryoyu çalıştırmak için, örneğin "Scenario: Scenario 1", yanındaki "run" butonu kullanılabilir.
   * "Background" bölümü, tüm senaryolar için ortak stepler içermektedir.
   * Steplerde bulunan " " içindeki değerler ilgili elementi temsil etmektedir.
   * 'src/test/resources/elementValues/HbScenariosElements.json' dosyasından ilgili elementlere değer atanır. Locator tipi belirtilir, key isimlendirmesi yapılır ve steplerde kullanılır.
   * Projenin içersinde ki 'apk' klasörüne en güncel Hepsiburada APK'sı eklenerek, test otomasyonu çalıştırılabilinir. 

## Projenin İçeriği

1. **Action.Java Hakkında**
   * `src/test/java/actions/Action.Java` dosyası açılır.
   * Bu dosya, ilgili senaryoların adımlarını içeren methodları barındırır. Aynı zamanda "Helper.Java" ile extend edilmiştir.
   * Action.Java içerisindeki methodlar, `CommonPage.Java` classından çağrılır.

2. **CommonPage.Java Hakkında**
   * `src/test/java/pages/CommonPage.Java` dosyası açılır.
   * Bu dosya, "Action.Java" içerisinde kullanılan methodları içerir. Bu methodlar, bir üst seviyedeki "CommonStep.Java" clasından çağrılmak üzere tanımlanır.
   * Aynı zamanda "Action.Java" ile extend edilmiştir.
   
3. **CommonStep.Java Hakkında**
   * `src/test/java/pages/CommonStep.Java` dosyası açılır.
   * Bu dosya içinde, Cucumber cümleleri bulunmaktadır.
   * CommonPage classından nesne oluşturularak, bu class içerisindeki methodlar kullanılır.
   * CommonStep classındaki Cucumber cümleleri, 'HbScenarios.feature' dosyasından çağrılmaktadır.
   
4. **utils.helpers Package Hakkında**
   1. **elementHelper Package İçerisindeki Classlar Hakkında**
      * HepsiburadaScenarios.json dosyasında kullanılan methodlar ve kodlar bu paket içerisindeki classlarda bulunmaktadır.
   2. **FileHelper.Java Hakkında**
      * Bu dosyadaki methodlar ve kodlar, elementHelper Package içerisindeki ElementMap.Java clasında kullanılmaktadır.
   3. **Helper.Java Hakkında**
      * Tüm yardımcı methodlar bu classta bulunmaktadır.

5. **utils.driver Package Hakkında**
   1. **MobileDriverSetUp Hakkında**
      * Appium Driver'ının başlatılacağı method buda bulunmaktadır. 
      * Appium GUI ile bağlantı kurulacak URL ve APK dosyasının yerini burdaki method içersinden belirlenmektedir.

## Yazar


