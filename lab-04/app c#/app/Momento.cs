using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app
{
    internal class Momento
    {
        Dictionary<int, List<Jednostka>> dictionary;
        

        public Momento()
        {
            dictionary = new Dictionary<int, List<Jednostka>>();

        }        
        


        public void create(int i, List<Jednostka> jednostki)
        {
            List<Jednostka> tempList = new List<Jednostka>();
            foreach (var item in jednostki)
            {
                tempList.Add(new Jednostka(item));
            }

            Console.WriteLine("create save " + i);
            if(!dictionary.ContainsKey(i))
                dictionary.Add(i, tempList);
            else
            {
                dictionary.Remove(i);
                dictionary.Add(i, tempList);
            }
        }
    




        public List<Jednostka> restore(int i)
        {


            Console.WriteLine("restore " + i);
            try {
                List<Jednostka> tempList = new List<Jednostka>();
                foreach (var item in dictionary[i])
                {
                    tempList.Add(new Jednostka(item));
                }
                Form1.iloscOsobnikow = dictionary[i].Count;
                return tempList;
            
            }
            catch {
                throw new Exception("ERROR - błąd przywrócenia pamiątki");  
                    }

        }



        
    }
}
