using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.Threading.Tasks;

namespace app
{

    class Vector2D : IVector
    {

        private State state;
        public double x { get; set; }
        public double y { get; set; }

        public Brush getColor()
        {
            return state.getColor();
        }
        public Vector2D(double x, double y)
        {
            this.state = new Odporny();
            this.x = x;
            this.y = y;
        }       
        public Vector2D(double x, double y, State state)
        {
            this.x = x;
            this.y = y;
            this.state = state;
        }
                                                                                                                                 


        public double abs()
        {
            return Math.Sqrt(x * x + y * y);
        }
        public double cdot(IVector vector)
        {
            return (vector.x * x + vector.y * y);
        }
        public double[] getComponents()
        {
            double[] tab = { x, y };
            return tab;
        }


    }




}
