# Ortak Hesap

Ercüment, Aişegül ve Murat için aylık ortak hesap uygulaması (Android).

- **Cari:** ayın 8'inde her kişiye yatan tutar.
- **Harcamalar:** her kişi yaptığı harcamaları tek tek ekler, otomatik toplanır.
- **Birbirine atılan paralar:** ödeme yapmak için biri diğerine para attıysa buraya yazılır.
- **Durum:** `cari − harcama − giden + gelen = elde kalan`.
- **Eşitleme:** toplam kalan üçe bölünür; herkesin eşit kalması için kimin kime ne kadar atacağı tabloda gösterilir.

Veriler telefonda saklanır; "Yeni ay" ile sıfırlanır.

## APK

Her push'ta GitHub Actions APK'yı derler ve **Releases** sayfasına `OrtakHesap.apk` olarak koyar.
Telefondan en son sürümü indirip kurmak yeterli (bilinmeyen kaynaklardan yüklemeye izin vermek gerekebilir).
