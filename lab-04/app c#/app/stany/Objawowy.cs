using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app
{
    class Objawowy : State
    {
        public Brush getColor()
        {
            return Brushes.Red;
        }

        public void kontakt(List<Jednostka> list, Jednostka j)
        {
  
            j.InfectedTimeSteps++;
            if (j.InfectedTimeSteps >= j.InfectedMaxTimeSteps)
            {
                j.changeState(new Odporny());
            //    Console.WriteLine("Objawowy => odporny");
            }

        }

        public State newInstance()
        {
            return new Objawowy();
        }
    }
}
