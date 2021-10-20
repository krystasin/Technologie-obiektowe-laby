using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Windows.Forms;

namespace app
{
    class Kantor
    {
        public List<Waluta> waluty = new List<Waluta>();

        public void loadData()
        {
            
            XmlDocument doc = new XmlDocument();
            doc.PreserveWhitespace = true;
            try
            {
            doc.Load("https://www.nbp.pl/kursy/xml/lasta.xml");
            //waluty clear
            }
            catch(Exception e) {
                MessageBox.Show("Nie udało sie załadować kursów", "Error");
            }


            XmlNodeList nodes = doc.DocumentElement.SelectNodes("/tabela_kursow/pozycja");

            string nazwa_waluty = "", kod_waluty = "";
            double przelicznik = 0.0f, kurs_sredni = 0.0f;
            foreach (XmlNode node in nodes)            {
                nazwa_waluty = node.SelectSingleNode("nazwa_waluty").InnerText;
                kod_waluty = node.SelectSingleNode("kod_waluty").InnerText;
                przelicznik = double.Parse(node.SelectSingleNode("przelicznik").InnerText);
                kurs_sredni = double.Parse(node.SelectSingleNode("kurs_sredni").InnerText);

                waluty.Add(new Waluta(nazwa_waluty, kod_waluty, przelicznik, kurs_sredni));
            }

        
        }
        public void wypiszListe()
        {
            foreach (Waluta w in waluty)
            {
                Console.WriteLine(w);
            }
        }
    }
}
