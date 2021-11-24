using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Threading.Tasks;

namespace app
{
    class Zdrowy : State
    {

        public State newInstance()
        {
            return new Zdrowy();
        }

        public void kontakt(List<Jednostka> list, Jednostka j)
        {
            Random rand = new Random();
            //todo zaraza sie od zakazonego (objawy/bez) <2m + 3sek (100%/50%)
            //ziostaje zakażony na 20-30 sek => odporny
            foreach (var item in list)
            {
                if (j == item) continue;

                double dist = j.distance(item);

                if (dist <= 2 && (item.State.GetType() == typeof(Objawowy) || item.State.GetType() == typeof(BezObjawowy)))
                {

                    if (j.dictionary.ContainsKey(item))
                    {
                        j.dictionary[item]++;

                        if (j.dictionary[item] > Form1.czasZakazenia)
                        {
                            //dodać 50% na bez objawowy
                            if (item.State.czyZakazi())
                            {
                                if(rand.Next(2) == 0)
                                    j.changeState(new BezObjawowy());  
                                else
                                    j.changeState(new Objawowy());
                                j.InfectedMaxTimeSteps = (rand.Next(10) + 20) * Form1.StepsPerSecond;
                                j.dictionary.Remove(item);
                            }

                        }
                    }
                    else
                        j.dictionary.Add(item, 1);

                }
                else
                {   // sprawdza czy jest w dictonary i ew usuwa
                    if(j.dictionary.ContainsKey(item))
                        j.dictionary.Remove(item);
                }
            }

        }
        public Brush getColor() => Brushes.Green;

        public bool czyZakazi() => false;
    }
}
