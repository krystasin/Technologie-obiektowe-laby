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
            return Brushes.OrangeRed;
        }

        public void kontakt()
        {
            throw new NotImplementedException();
        }
    }
}
