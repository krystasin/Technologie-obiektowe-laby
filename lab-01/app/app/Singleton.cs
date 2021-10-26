using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace app
{
    class Singleton
    {
        private Singleton() { kantor = new Kantor(); }

        private static Singleton singleton = null;
        public Kantor kantor;

        public static Singleton GetSingleton()
        {
            if(singleton == null)
            {
                singleton = new Singleton();
            }
            return singleton;
        }


    }
}
