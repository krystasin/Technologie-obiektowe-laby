using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app
{
    class BezObjawowy : State
    {
        public Brush getColor()
        {
            return Brushes.Orange;
        }

        public void kontakt(List<Jednostka> list, Jednostka j)
        {
            j.InfectedTimeSteps++;
            if (j.InfectedTimeSteps >= j.InfectedMaxTimeSteps)
            {
                j.changeState(new Odporny());
            //    Console.WriteLine("BezObjawowy => odporny");
            }

        
        }

        public State newInstance()
        {
            return new BezObjawowy();
        }

        public bool czyZakazi()
        {
            Random random = new Random();
            if(random.Next(2) == 0)
                return false;
            return true;
        }
    }
}
