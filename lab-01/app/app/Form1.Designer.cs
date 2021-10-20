

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
            this.waluta_form_in = new System.Windows.Forms.TextBox();
            this.waluta_list_from = new System.Windows.Forms.ComboBox();
            this.waluta_list_to = new System.Windows.Forms.ComboBox();
            this.text_1 = new System.Windows.Forms.Label();
            this.waluta_form_out = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // waluta_form_in
            // 
            this.waluta_form_in.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.waluta_form_in.Location = new System.Drawing.Point(22, 51);
            this.waluta_form_in.Name = "waluta_form_in";
            this.waluta_form_in.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.waluta_form_in.Size = new System.Drawing.Size(97, 24);
            this.waluta_form_in.TabIndex = 0;
            this.waluta_form_in.TextChanged += new System.EventHandler(this.waluta_form_in_TextChanged);
            this.waluta_form_in.Enter += new System.EventHandler(this.waluta_form_in_Enter);
            // 
            // waluta_list_from
            // 
            this.waluta_list_from.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.waluta_list_from.FormattingEnabled = true;
            this.waluta_list_from.Location = new System.Drawing.Point(127, 51);
            this.waluta_list_from.Name = "waluta_list_from";
            this.waluta_list_from.Size = new System.Drawing.Size(215, 24);
            this.waluta_list_from.TabIndex = 2;
            this.waluta_list_from.SelectionChangeCommitted += new System.EventHandler(this.waluta_list_from_SelectionChangeCommitted);
            // 
            // waluta_list_to
            // 
            this.waluta_list_to.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.waluta_list_to.FormattingEnabled = true;
            this.waluta_list_to.Location = new System.Drawing.Point(348, 51);
            this.waluta_list_to.Name = "waluta_list_to";
            this.waluta_list_to.Size = new System.Drawing.Size(215, 24);
            this.waluta_list_to.TabIndex = 3;
     //       this.waluta_list_to.Text = string.Format("{0:0.00}, number"); 
            this.waluta_list_to.SelectionChangeCommitted += new System.EventHandler(this.waluta_list_to_SelectionChangeCommitted);
            // 
            // text_1
            // 
            this.text_1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.text_1.Location = new System.Drawing.Point(18, 23);
            this.text_1.Name = "text_1";
            this.text_1.Size = new System.Drawing.Size(127, 25);
            this.text_1.TabIndex = 4;
            this.text_1.Text = "po przeliczeniu:";
            // 
            // waluta_form_out
            // 
            this.waluta_form_out.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.waluta_form_out.Location = new System.Drawing.Point(137, 23);
            this.waluta_form_out.Name = "waluta_form_out";
            this.waluta_form_out.ReadOnly = true;
            this.waluta_form_out.Size = new System.Drawing.Size(426, 24);
            this.waluta_form_out.TabIndex = 5;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(587, 259);
            this.Controls.Add(this.waluta_form_out);
            this.Controls.Add(this.text_1);
            this.Controls.Add(this.waluta_list_to);
            this.Controls.Add(this.waluta_list_from);
            this.Controls.Add(this.waluta_form_in);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.Fixed3D;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox waluta_form_in;
        private System.Windows.Forms.ComboBox waluta_list_from;
        private System.Windows.Forms.ComboBox waluta_list_to;
        private System.Windows.Forms.Label text_1;
        private System.Windows.Forms.TextBox waluta_form_out;
    }
}

