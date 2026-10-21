# ASM Cari Hesaplama

Aile Sağlığı Merkezi hekimleri için aylık cari paylaşım hesaplayıcısı (Android).

- **Kişiler ve cari:** varsayılan "Doktor 1", "Doktor 2"; "Kişi ekle" ile çoğalır, isimler değiştirilebilir.
- **Harcamalar:** her kişi harcamalarını tek tek ekler, otomatik toplanır.
- **Birbirine atılan paralar:** ödeme için biri diğerine para attıysa kaydedilir.
- **Durum:** `cari − harcama − giden + gelen = elde kalan`.
- **Eşitleme:** toplam kalan kişi sayısına bölünür; kimin kime ne kadar atacağı gösterilir ve paylaşılabilir.

Veriler yalnızca telefonda saklanır; "Yeni ay" kişileri koruyup rakamları sıfırlar.

## İndirme
Her push'ta GitHub Actions derler ve **Releases** sayfasına koyar:
- `ASM-Cari-Hesaplama.apk` — telefona doğrudan kurmak için
- `ASM-Cari-Hesaplama-PlayStore.aab` — Google Play'e yüklemek için (`UPLOAD_KEY_PASSWORD` tanımlıysa)

Play Store'a yükleme adımları: [play-store/YUKLEME-REHBERI.md](play-store/YUKLEME-REHBERI.md)
