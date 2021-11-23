namespace app
{
    partial class Form1
    {
        /// <summary>
        /// Wymagana zmienna projektanta.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Wyczyść wszystkie używane zasoby.
        /// </summary>
        /// <param name="disposing">prawda, jeżeli zarządzane zasoby powinny zostać zlikwidowane; Fałsz w przeciwnym wypadku.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Kod generowany przez Projektanta formularzy systemu Windows

        /// <summary>
        /// Metoda wymagana do obsługi projektanta — nie należy modyfikować
        /// jej zawartości w edytorze kodu.
        /// </summary>
        private void InitializeComponent()
        {
            this.drawArea = new System.Windows.Forms.Panel();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button4 = new System.Windows.Forms.Button();
            this.restore1 = new System.Windows.Forms.Button();
            this.restore2 = new System.Windows.Forms.Button();
            this.restore3 = new System.Windows.Forms.Button();
            this.restore4 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // drawArea
            // 
            this.drawArea.BackColor = System.Drawing.Color.Black;
            this.drawArea.Location = new System.Drawing.Point(0, 30);
            this.drawArea.Name = "drawArea";
            this.drawArea.Size = new System.Drawing.Size(800, 600);
            this.drawArea.TabIndex = 0;
            this.drawArea.Paint += new System.Windows.Forms.PaintEventHandler(this.draw);
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(0, 0);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(100, 30);
            this.button1.TabIndex = 1;
            this.button1.Text = "save 1";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(100, 0);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(100, 30);
            this.button2.TabIndex = 2;
            this.button2.Text = "save to 2";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(200, 0);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(100, 30);
            this.button3.TabIndex = 3;
            this.button3.Text = "save to 3";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(300, 0);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(100, 30);
            this.button4.TabIndex = 4;
            this.button4.Text = "save to 4";
            this.button4.UseVisualStyleBackColor = true;
            this.button4.Click += new System.EventHandler(this.button4_Click);
            // 
            // restore1
            // 
            this.restore1.Location = new System.Drawing.Point(400, 0);
            this.restore1.Name = "restore1";
            this.restore1.Size = new System.Drawing.Size(100, 30);
            this.restore1.TabIndex = 5;
            this.restore1.Text = "restore1";
            this.restore1.UseVisualStyleBackColor = true;
            this.restore1.Click += new System.EventHandler(this.restore1_Click);
            // 
            // restore2
            // 
            this.restore2.Location = new System.Drawing.Point(500, 0);
            this.restore2.Name = "restore2";
            this.restore2.Size = new System.Drawing.Size(100, 30);
            this.restore2.TabIndex = 6;
            this.restore2.Text = "restore2";
            this.restore2.UseVisualStyleBackColor = true;
            this.restore2.Click += new System.EventHandler(this.restore2_Click);
            // 
            // restore3
            // 
            this.restore3.Location = new System.Drawing.Point(600, 0);
            this.restore3.Name = "restore3";
            this.restore3.Size = new System.Drawing.Size(100, 30);
            this.restore3.TabIndex = 7;
            this.restore3.Text = "restore 3";
            this.restore3.UseVisualStyleBackColor = true;
            this.restore3.Click += new System.EventHandler(this.restore3_Click);
            // 
            // restore4
            // 
            this.restore4.Location = new System.Drawing.Point(700, 0);
            this.restore4.Name = "restore4";
            this.restore4.Size = new System.Drawing.Size(100, 30);
            this.restore4.TabIndex = 8;
            this.restore4.Text = "restore 4";
            this.restore4.UseVisualStyleBackColor = true;
            this.restore4.Click += new System.EventHandler(this.restore4_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.BackColor = System.Drawing.Color.DimGray;
            this.ClientSize = new System.Drawing.Size(800, 630);
            this.Controls.Add(this.restore4);
            this.Controls.Add(this.restore3);
            this.Controls.Add(this.restore2);
            this.Controls.Add(this.restore1);
            this.Controls.Add(this.button4);
            this.Controls.Add(this.button3);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.drawArea);
            this.DoubleBuffered = true;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Form1";
            this.Text = "Symulator lab 04";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.Form1_KeyPress);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel drawArea;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button restore1;
        private System.Windows.Forms.Button restore2;
        private System.Windows.Forms.Button restore3;
        private System.Windows.Forms.Button restore4;
    }
}

