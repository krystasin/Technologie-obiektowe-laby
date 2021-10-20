using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace app
{
    class Waluta
    {
        private String nazwa;
        private String kod;
        private double przelicznik;
        private double kurs_sredni;

        public Waluta(String nazwa, String kod, double przelicznik, double kurs)
        {
            this.nazwa = nazwa;
            this.kod = kod;
            this.przelicznik = przelicznik;
            this.kurs_sredni = kurs;
        }












        public string Nazwa { get => nazwa; set => nazwa = value; }
        public string Kod { get => kod; set => kod = value; }
        public double Przelicznik { get => przelicznik; set => przelicznik = value; }
        public double Kurs { get => kurs_sredni; set => kurs_sredni = value; }

        public override string ToString() =>  kod.ToUpper() + " - " + nazwa;

        public double getKurs() { return Kurs; }

    }
}
