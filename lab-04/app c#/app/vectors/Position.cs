using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app
{
    class Position : Vector2D
    {
        public Position(double x, double y) : base(x, y)
        {
        }
        public Position(Position p) : base(p.X, p.Y)
        {
        }


        public void changePosition(Movement movement, double velocity)
        {
            X += movement.X * velocity / Form1.StepsPerSecond;
            Y += movement.Y * velocity / Form1.StepsPerSecond;
        }

    }
}
