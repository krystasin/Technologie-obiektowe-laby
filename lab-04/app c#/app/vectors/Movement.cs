using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app
{
    class Movement : Vector2D
    {
        public Movement(double x, double y) : base(x, y)
        {
        }        
        public Movement(Movement m) : base(m.X, m.Y)
        {
        }


        public void Standarize()
        {
            double dl = this.abs();
            X /= dl;
            Y /= dl;

        }

        internal void randomChange()
        {
            Random random = new Random();
            if (random.Next(20) == 0)
            {
                int znak = random.Next(2);
                if (znak == 0) znak = -1;

                if (Math.Abs(X) > Math.Abs(Y)) 
                    Y += znak * random.NextDouble() / 4;
                else 
                    X += znak * random.NextDouble() / 4;
                
                this.Standarize();
            }
        }
    }
}
