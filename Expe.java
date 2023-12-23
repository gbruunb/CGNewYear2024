import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class Expe extends JPanel {
    public static void main(String[] args) {
        Expe m = new Expe();

        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("First Swing");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);

    }

    public void paintComponent(Graphics g) {
        BufferedImage buffer = new BufferedImage(601, 601, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();

        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 600, 600);
        // sky
        sky(g2d, buffer);
        // graass
        grass(g2d, buffer);
        // table
        table(g2d, buffer);
        // computer
        computer(g2d, buffer);
        // cup
        // cup(g2);
        // mattress
        // mattress(g2);

        cat(g2d, buffer, 30);

        g.setColor(Color.WHITE);

        bezier_Curve(g2d,new int[]{10,5,30}, new int[]{20,30,30});


        g.drawImage(buffer, 0, 0, null);

    }

    public void plot(Graphics g, int x, int y) {
        g.fillRect(x, y, 1, 1);
    }

    private void cat(Graphics g, BufferedImage buffer, int y) {
        g.setColor(Color.black);
        //head
        bezier_Curve(g, new int[] { 338, 330,  325}, new int[] { 493, 487,  484});
        bezier_Curve(g, new int[] { 321, 324,  325}, new int[] { 484, 483,  484});
        bezier_Curve(g, new int[] { 321, 324,  321, 321}, new int[] { 484, 484,  485, 486});
        bezier_Curve(g, new int[] { 321, 321,  322}, new int[] { 486, 487,  488});
        bezier_Curve(g, new int[] { 322, 322, 322}, new int[] { 488, 490, 491});
        bezier_Curve(g, new int[] { 322, 323, 323}, new int[] { 491, 491, 492});
        bezier_Curve(g, new int[] { 323, 324,  324}, new int[] { 492, 493,  494});
        bezier_Curve(g, new int[] { 321, 324,  325, 326}, new int[] { 484, 495,  495, 498});
        bezier_Curve(g, new int[] { 326, 327,  327, 327}, new int[] { 498, 499,  500, 500});
        bezier_Curve(g, new int[] { 327, 328,  327, 328}, new int[] { 500, 502,  502, 504});
        bezier_Curve(g, new int[] { 328, 328,  328, 329}, new int[] { 504, 505,  505, 506});
        bezier_Curve(g, new int[] { 329, 330,  330, 330}, new int[] { 506, 507,  507, 508});
        bezier_Curve(g, new int[] { 330, 330,  330, 330}, new int[] { 508, 509,  509, 510});
        bezier_Curve(g, new int[] { 330, 329,  329, 329}, new int[] { 510, 511,  512, 514});
        bezier_Curve(g, new int[] { 329, 329,  329, 329}, new int[] { 514, 517,  517, 519});
        bezier_Curve(g, new int[] { 329, 329,  329, 329}, new int[] { 519, 520,  521, 522});
        bezier_Curve(g, new int[] { 329, 329,  328, 329}, new int[] { 522, 526,  527, 529});
        bezier_Curve(g, new int[] { 329, 329,  329, 329}, new int[] { 529, 529,  530, 530});
        bezier_Curve(g, new int[] { 329, 330,  329, 330}, new int[] { 530, 531,  531, 532});
        bezier_Curve(g, new int[] { 330, 330,  330, 331}, new int[] { 532, 532,  532, 533});
        bezier_Curve(g, new int[] { 331, 332,  331, 332}, new int[] { 533, 534,  534, 536});
        bezier_Curve(g, new int[] { 332, 333,  333, 333}, new int[] { 536, 537,  537, 538});
        bezier_Curve(g, new int[] { 333, 334,  334, 334}, new int[] { 538, 539,  539, 540});
        bezier_Curve(g, new int[] { 334, 334,  335, 335}, new int[] { 540, 541,  541, 542});
        bezier_Curve(g, new int[] { 335, 336,  336, 337}, new int[] { 542, 543,  544, 544});
        bezier_Curve(g, new int[] { 337, 337,  337, 337}, new int[] { 544, 544,  544, 544});
        bezier_Curve(g, new int[] { 337, 337,  337, 337}, new int[] { 544, 543,  543, 542});
        bezier_Curve(g, new int[] { 337, 337,  340, 341}, new int[] { 542, 541,  541, 540});
        bezier_Curve(g, new int[] { 341, 342,  342, 345}, new int[] { 540, 540,  540, 540});
        bezier_Curve(g, new int[] { 345, 346,  347, 348}, new int[] { 540, 540,  540, 539});
        bezier_Curve(g, new int[] { 348, 350,  351, 351}, new int[] { 539, 540,  539, 538});
        bezier_Curve(g, new int[] { 351, 351,  351, 352}, new int[] { 538, 538,  537, 538});
        bezier_Curve(g, new int[] { 352, 353,  353, 354}, new int[] { 538, 537,  538, 538});
        bezier_Curve(g, new int[] { 354, 356,  360, 361}, new int[] { 538, 540,  540, 538});
        bezier_Curve(g, new int[] { 361, 361,  361, 361}, new int[] { 538, 538,  538, 538});
        bezier_Curve(g, new int[] { 361, 363,  364, 365}, new int[] { 538, 537,  538, 537});
        bezier_Curve(g, new int[] { 365, 366,  366, 366}, new int[] { 537, 536,  536, 535});
        bezier_Curve(g, new int[] { 366, 367,  369, 372}, new int[] { 535, 537,  532, 530});
        bezier_Curve(g, new int[] { 372, 375,  376, 377}, new int[] { 530, 529,  529, 528});
        bezier_Curve(g, new int[] { 377, 378,  378, 379}, new int[] { 528, 528,  528, 528});
        bezier_Curve(g, new int[] { 379, 380,  380, 381}, new int[] { 528, 528,  528, 528});
        bezier_Curve(g, new int[] { 381, 382,  382, 382}, new int[] { 528, 528,  527, 527});
        bezier_Curve(g, new int[] { 382, 382,  382, 382}, new int[] { 527, 526,  526, 525});
        bezier_Curve(g, new int[] { 382, 382,  382, 383}, new int[] { 525, 525,  525, 524});
        bezier_Curve(g, new int[] { 383, 383,  383, 383}, new int[] { 524, 523,  523, 521});
        bezier_Curve(g, new int[] { 383, 383, 382}, new int[] { 521, 520, 519});
        bezier_Curve(g, new int[] { 382, 382,  383, 383}, new int[] { 519, 517,  517, 515});
        bezier_Curve(g, new int[] { 383, 382,  383, 383}, new int[] { 515, 517,  517, 515});
        bezier_Curve(g, new int[] { 383, 382,  382, 382}, new int[] { 515, 514,  513, 512});
        bezier_Curve(g, new int[] { 382, 382,  382, 382}, new int[] { 512, 510,  509, 509});
        bezier_Curve(g, new int[] { 382, 382,  382, 381}, new int[] { 509, 508,  507, 507});
        bezier_Curve(g, new int[] { 381, 381,  382, 382}, new int[] { 507, 506,  506, 506});
        bezier_Curve(g, new int[] { 382, 384,  384, 384}, new int[] { 506, 505,  505, 501});
        bezier_Curve(g, new int[] { 384, 384,  383, 384}, new int[] { 501, 501,  500, 499});
        bezier_Curve(g, new int[] { 384, 384,  384, 385}, new int[] { 499, 499,  499, 498});
        bezier_Curve(g, new int[] { 385, 385,  385, 387}, new int[] { 498, 498,  497, 494});
        bezier_Curve(g, new int[] { 387, 389,  389, 389}, new int[] { 494, 490,  490, 490});
        bezier_Curve(g, new int[] { 389, 390,  390, 391}, new int[] { 490, 488,  488, 487});
        bezier_Curve(g, new int[] { 391, 391,  392, 390}, new int[] { 487, 487,  484, 483});
        bezier_Curve(g, new int[] { 390, 390,  389, 389}, new int[] { 483, 483,  483, 483});
        bezier_Curve(g, new int[] { 389, 388,  388, 388}, new int[] { 483, 483,  483, 483});
        bezier_Curve(g, new int[] { 388, 381,  376}, new int[] { 483, 488,  491});
        bezier_Curve(g, new int[] { 376, 374,  373, 372}, new int[] { 491, 492,  493, 493});
        bezier_Curve(g, new int[] { 372, 371,  371, 370}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 370, 368,  368, 368}, new int[] { 493, 494,  494, 494});
        bezier_Curve(g, new int[] { 368, 366,  364, 362}, new int[] { 494, 495,  492, 493});
        bezier_Curve(g, new int[] { 362, 362,  362, 361}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 361, 360,  360, 359}, new int[] { 493, 493,  493, 492});
        bezier_Curve(g, new int[] { 359, 358,  358, 356}, new int[] { 492, 492,  492, 493});
        bezier_Curve(g, new int[] { 356, 355,  355, 353}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 353, 353,  352, 351}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 351, 348,  347, 346}, new int[] { 493, 493,  493, 493});
        bezier_Curve(g, new int[] { 346, 345,  345, 344}, new int[] { 493, 493,  494, 494});
        bezier_Curve(g, new int[] { 344, 342,  340, 339}, new int[] { 494, 496,  494, 494});
        bezier_Curve(g, new int[] { 339, 339,  338}, new int[] { 494, 493,  493});
        bezier_Curve(g, new int[] { 338, 330,  325}, new int[] { 493, 487,  484});
        bezier_Curve(g, new int[] { 325, 324,  321}, new int[] { 484, 483,  484});

        //left-eye
        bezier_Curve(g, new int[] { 341, 341,  342, 343}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 343, 344,  344, 346}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 346, 347,  348, 350}, new int[] { 510, 510,  510, 511});
        bezier_Curve(g, new int[] { 350, 351,  352, 352}, new int[] { 511, 511,  512, 513});
        bezier_Curve(g, new int[] { 352, 352,  352, 352}, new int[] { 513, 513,  514, 514});
        bezier_Curve(g, new int[] { 352, 352,  352, 350}, new int[] { 514, 514,  515, 515});
        bezier_Curve(g, new int[] { 350, 347,  344, 344}, new int[] { 515, 516,  514, 514});
        bezier_Curve(g, new int[] { 344, 342,  341, 341}, new int[] { 514, 512,  511, 511});
        bezier_Curve(g, new int[] { 341, 341,  341, 341}, new int[] { 511, 510,  510, 510});

        //inner-left-eye
        bezier_Curve(g, new int[] { 345, 345,  345, 345}, new int[] { 511, 509,  512, 512});
        bezier_Curve(g, new int[] { 345, 345,  345, 346}, new int[] { 512, 512,  514, 514});
        bezier_Curve(g, new int[] { 346, 347,  348, 348}, new int[] { 514, 514,  513, 512});
        bezier_Curve(g, new int[] { 348, 348,  348, 348}, new int[] { 512, 511,  511, 510});

        buffer = floodFill(buffer, 346, 512, Color.decode("#80C014"), Color.decode("#000000"));



        //right-eye
        bezier_Curve(g, new int[] { 364, 364,  364, 365}, new int[] { 514, 513,  513, 512});
        bezier_Curve(g, new int[] { 365, 366,  368, 369}, new int[] { 512, 510,  510, 510});
        bezier_Curve(g, new int[] { 369, 370,  370, 371}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 371, 374,  375, 375}, new int[] { 510, 510,  510, 510});
        bezier_Curve(g, new int[] { 375, 375,  374, 373}, new int[] { 510, 511,  512, 513});
        bezier_Curve(g, new int[] { 373, 372,  371, 369}, new int[] { 513, 514,  515, 515});
        bezier_Curve(g, new int[] { 369, 367,  364, 364}, new int[] { 515, 515,  515, 514});

        //inner right eye
        bezier_Curve(g, new int[] { 367, 367,  367, 368}, new int[] { 511, 510,  513, 513});
        bezier_Curve(g, new int[] { 368, 369,  369, 370}, new int[] { 513, 513,  513, 513});
        bezier_Curve(g, new int[] { 370, 371,  371, 370}, new int[] { 513, 512,  511, 510});
        buffer = floodFill(buffer, 369, 511, Color.decode("#80C014"), Color.decode("#000000"));

        //pre-nose
        bezier_Curve(g, new int[] { 351, 351,  352, 352}, new int[] { 514, 515,  516, 518});
        bezier_Curve(g, new int[] { 352, 353,  353, 354}, new int[] { 518, 522,  525, 525});
        bezier_Curve(g, new int[] { 363, 363,  364, 364}, new int[] { 526, 526,  525, 525});
        bezier_Curve(g, new int[] { 364, 365,  364, 364}, new int[] { 525, 524,  522, 521});
        bezier_Curve(g, new int[] { 364, 364,  363, 364}, new int[] { 521, 520,  518, 515});

        g.setColor(Color.decode("#5A3F2B"));
        g.drawPolygon(new int[]{354, 364, 359}, new int[]{525, 525, 530}, 3);
        g.setColor(Color.decode("#000000"));
        g.drawPolygon(new int[]{360, 361, 362, 361}, new int[]{527, 526, 527, 528}, 4);
        buffer = floodFill(buffer, 361, 527, Color.decode("#80C014"), Color.decode("#000000"));

        g.drawPolygon(new int[]{355, 356, 357, 356}, new int[]{526, 526, 526, 527}, 4);
        buffer = floodFill(buffer, 356, 526, Color.decode("#80C014"), Color.decode("#000000"));
        buffer = floodFill(buffer, 359, 526, Color.decode("#80C014"), Color.decode("#5A3F2B"));
//        buffer = floodFill(buffer, 360, 527, Color.decode("#80C014"), Color.decode("#5A3F2B"));

        //collar
        bezier_Curve(g, new int[] { 337, 337,  337, 337}, new int[] { 545, 542,  545, 547});
        bezier_Curve(g, new int[] { 337, 337,  338, 338}, new int[] { 547, 548,  547, 548});
        bezier_Curve(g, new int[] { 338, 338,  338, 338}, new int[] { 548, 549,  549, 550});
        bezier_Curve(g, new int[] { 338, 338,  339, 339}, new int[] { 550, 550,  551, 551});
        bezier_Curve(g, new int[] { 339, 340,  340, 340}, new int[] { 551, 551,  550, 550});
        bezier_Curve(g, new int[] { 340, 340,  340, 340}, new int[] { 550, 550,  551, 551});
        bezier_Curve(g, new int[] { 340, 341,  346, 347}, new int[] { 551, 552,  549, 549});
        bezier_Curve(g, new int[] { 347, 348,  348, 349}, new int[] { 549, 549,  549, 548});
        bezier_Curve(g, new int[] { 349, 356,  358, 359}, new int[] { 548, 544,  545, 543});
        bezier_Curve(g, new int[] { 359, 356,  358, 359}, new int[] { 543, 545,  545, 543});
        bezier_Curve(g, new int[] { 359, 359,  360, 361}, new int[] { 543, 542,  541, 541});
        bezier_Curve(g, new int[] { 361, 362,  362, 363}, new int[] { 541, 541,  541, 541});
        bezier_Curve(g, new int[] { 363, 364,  364, 365}, new int[] { 541, 541,  540, 540});
        bezier_Curve(g, new int[] { 365, 366,  367, 368}, new int[] { 540, 540,  539, 539});
        bezier_Curve(g, new int[] { 368, 372,  374, 376}, new int[] { 539, 538,  539, 537});
        bezier_Curve(g, new int[] { 376, 376,  377, 377}, new int[] { 537, 537,  536, 536});
        bezier_Curve(g, new int[] { 377, 378,  379, 379}, new int[] { 536, 535,  534, 533});
        bezier_Curve(g, new int[] { 379, 380,  380, 382}, new int[] { 533, 532,  531, 530});
        bezier_Curve(g, new int[] { 382, 382,  381, 381}, new int[] { 530, 530,  530, 529});
        bezier_Curve(g, new int[] { 381, 381,  381, 381}, new int[] { 529, 529,  528, 528});

        //body
        bezier_Curve(g, new int[] { 338, 337, 337}, new int[] { 550, 552, 553});
        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
        bezier_Curve(g, new int[] { 335, 335, 335, 335}, new int[] { 558, 559, 560, 562});
        bezier_Curve(g, new int[] { 335, 335, 335, 335}, new int[] { 562, 563, 565, 567});
        bezier_Curve(g, new int[] { 335, 336, 352, 394}, new int[] { 567, 570, 566, 568});
        bezier_Curve(g, new int[] { 394, 394, 394, 395}, new int[] { 568, 568, 568, 568});
        bezier_Curve(g, new int[] { 395, 399, 397, 394}, new int[] { 568, 567, 536, 532});
        bezier_Curve(g, new int[] { 394, 393, 392, 388}, new int[] { 532, 531, 532, 531});
        bezier_Curve(g, new int[] { 388, 385, 384, 382}, new int[] { 531, 530, 529, 530});







//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});
//        bezier_Curve(g, new int[] { 337, 336, 335, 335}, new int[] { 553, 556, 556, 558});

    }

    private static void sky(Graphics g, BufferedImage buffer) {
        g.setColor(new Color(9, 30, 60));
        bresenhamLine(g, 0, 350, 600, 350);
        buffer = floodFill(buffer, 0, 10, Color.WHITE, new Color(9, 30, 60));
    }

    private static void grass(Graphics g, BufferedImage buffer) {
        // g.setColor(new Color(128, 192, 20));
        // g.setColor(Color.decode("#80C014"));
        // g.fillRect(0, 350, 600, 240);
        // g.setColor(new Color(128, 192, 20 ));
        bresenhamLine(g, 0, 600 - 30, 600, 600 - 30);
        buffer = floodFill(buffer, 0, 599 - 30, Color.WHITE, Color.decode("#80C014"));

    }

    private void drawRectToBresen(Graphics g, int x, int y, int width, int height) {
        // top
        int x1 = x;
        int y1 = y;
        int x2 = x1 + width;
        int y2 = y1;
        bresenhamLine(g, x1, y1, x2, y2);
        // left
        x2 = x1;
        y2 = y1 + height;
        bresenhamLine(g, x1, y1, x2, y2);
        // down
        x1 = x2;
        y1 = y2;
        x2 = x1 + width;
        y2 = y1;
        bresenhamLine(g, x1, y1, x2, y2);
        // right
        x1 = x2;
        y1 = y2;
        y2 = y2 - height;
        bresenhamLine(g, x1, y1, x2, y2);
    }

    private void drawRectToBresen2(Graphics g, int x, int y, int width, int height, int curve) {
        int curveHalf = curve / 2;
        int curveHalf2 = curveHalf / 2;
        // top
        int x1 = x;
        int y1 = y;
        int x2 = x1 + width;
        int y2 = y1;
        bresenhamLine(g, x1 + curve, y1, x2 - curve, y2);
        // left
        x2 = x1;
        y2 = y1 + height;
        bresenhamLine(g, x, y1 + curve, x, y2 - curve);
        bezier_Curve(g, new int[] { x, x1, x1 + curve }, new int[] { y1 + curve, y1, y1 });
        // bezier_Curve(g, new int[] { x1, x1, x1 + curve }, new int[] { y1 + curve, y1, y1 });

        // down
        x1 = x2;
        y1 = y2;
        x2 = x1 + width;
        y2 = y1;
        bresenhamLine(g, x1 + curve, y1, x2 - curve, y2);
        bezier_Curve(g, new int[] { x1 , x1,x1 +curve },
                new int[] { y2-curve,y2,y2});
        // right
        x1 = x2;
        y1 = y2;
        y2 = y2 - height;
        bresenhamLine(g, x1, y1 - curve, x2, y2 + curve);
    }

    private void table(Graphics g, BufferedImage buffer) {
        Color replaceColor;
        // body
        g.setColor(Color.decode("#AF6329"));
        // g.drawRoundRect(1,460 - 30 ,300 , 20 ,0 , 0);
        // g.fillRoundRect(1, 460 - 30, 300, 20, 10, 15);
        // bresenhamLine(g, 1, 460 - 30, 300, 460 - 30);
        // bresenhamLine(g, 1, 480 - 30, 300, 480 - 30);
        // drawRectToBresen(g, 1, 460 - 30, 300, 20);
        drawRectToBresen2(g, 1, 460 - 30, 300, 20, 7);
        // buffer = floodFill(buffer, 2, 461 - 30 , Color.decode("#80C014"),
        // Color.decode("#AF6329"));

        // left leg
        // g.fillRect(15, 480 - 30, 20, 120);
        // bresenhamLine(g, 15, 460-30, 15, 600 - 30);
        // bresenhamLine(g, 35, 460-30, 35, 600 - 30);
        drawRectToBresen(g, 15, 480 - 30, 20, 120);
        buffer = floodFill(buffer, 16, 481 - 30, Color.decode("#80C014"), Color.decode("#AF6329"));

        // middle part
        g.setColor(Color.decode("#A25424"));
        replaceColor = Color.decode("#A25424");
        // g.fillRect(35, 510 - 30, 160, 20);
        drawRectToBresen(g, 35, 510 - 30, 155, 20);
        buffer = floodFill(buffer, 36, 511 - 30, Color.decode("#80C014"), replaceColor);

        // red box
        g.setColor(Color.decode("#EC2C39"));
        replaceColor = Color.decode("#EC2C39");
        // g.fillRect(190, 480 - 30, 85, 120);
        drawRectToBresen(g, 190, 481 - 30, 85, 120);
        buffer = floodFill(buffer, 191, 482 - 30, Color.decode("#80C014"), replaceColor);

        // half box
        g.setColor(Color.decode("#CB1F2B"));
        replaceColor = Color.decode("#CB1F2B");
        // g.fillRect(190, (480 + 120 / 2) - 30, 85, 10);
        drawRectToBresen(g, 190, (480 + 120 / 2) - 30, 85, 10);

        buffer = floodFill(buffer, 191, (481 + 120 / 2) - 30 + 1, Color.decode("#EC2C39"), replaceColor);

        // puller1
        g.setColor(Color.decode("#F6B74E"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(215, 495 - 30, 37, 10);
        drawRectToBresen(g, 215, 495 - 30, 37, 10);
        buffer = floodFill(buffer, 216, 496 - 30, Color.decode("#EC2C39"), replaceColor);

        // puller2
        g.setColor(Color.decode("#F6B74E"));
        replaceColor = Color.decode("#F6B74E");
        // g.fillRect(215, 567 - 30, 37, 10);
        drawRectToBresen(g, 215, 567 - 30, 37, 10);
        buffer = floodFill(buffer, 216, 568 - 30, Color.decode("#EC2C39"), replaceColor);
    }

    private void computer(Graphics g, BufferedImage buffer) {
        Color replaceColor;
        // base

        g.setColor(Color.decode("#353939"));
        replaceColor = Color.decode("#353939");
        // g.fillRect(38, 450 - 30, 132, 10);
        drawRectToBresen(g, 38, 450 - 30, 132, 10);
        buffer = floodFill(buffer, 39, 451 - 30, replaceColor);

        // Monitor
        // g.fillRoundRect(48, 360 - 30, 110, 85, 15, 15);
        drawRectToBresen(g, 48, 360 - 30, 110, 85);

        // gray top tap
        g.setColor(Color.decode("#95A5A6"));
        // g.fillRect(55, 367 - 30, 97, 10);
        drawRectToBresen(g, 55, 367 - 30, 97, 10);
        // white top tap
        g.setColor(Color.WHITE);
        // g.fillRect(55, 375 - 30, 97, 3);
        drawRectToBresen(g, 55, 375 - 30, 97, 3);

        // bg
        g.setColor(Color.decode("#3F4E4D"));
        // g.fillRect(55, 378 - 30, 97, 60);
        drawRectToBresen(g, 55, 378 - 30, 97, 60);
        // long green
        g.setColor(Color.decode("#6B9C27"));
        // g.fillRect(62, 378 - 30, 2, 60);
        drawRectToBresen(g, 62, 378 - 30, 2, 60);

        // orange in screen
        g.setColor(Color.ORANGE);
        // g.fillRect(68, 389 - 30, 4, 2);
        drawRectToBresen(g, 68, 389 - 30, 4, 2);
        // g.fillRect(68, 399 - 30, 9, 2);
        drawRectToBresen(g, 68, 399 - 30, 9, 2);

        // Blue in screen
        g.setColor(Color.decode("#34A3E8"));
        // g.fillRect(75, 389 - 30, 4, 2);
        drawRectToBresen(g, 75, 389 - 30, 4, 2);
        // g.fillRect(103, 399 - 30, 15, 2);
        drawRectToBresen(g, 103, 399 - 30, 15, 2);
        // g.fillRect(85, 420 - 30, 15, 2);
        drawRectToBresen(g, 85, 420 - 30, 15, 2);

        // Purple in screen
        g.setColor(Color.decode("#864B9B"));
        // g.fillRect(75, 412 - 30, 4, 2);
        drawRectToBresen(g, 75, 412 - 30, 4, 2);
        // g.fillRect(103, 420 - 30, 15, 2);
        drawRectToBresen(g, 103, 420 - 30, 15, 2);
    }

    private void cup(Graphics g) {
        // white shadow
        g.setColor(Color.white);
        g.fillArc(185, 446 - 30, 35, 10, 0, 360);

        // g.setColor(Color.white);
        // g.fillOval(218, 428-30, 12, 12);

        g.setColor(Color.red);
        g.drawArc(210, 430 - 30, 20, 15, -80, 180);
        // outside cup handle
        g.drawArc(210, 430 - 30, 25, 16, -90, 180);

        // try outside cup handle fk this too hard
        // g.fillArc(220, 430-30, 20, 16, -90, 180);

        g.setColor(Color.black);
        g.fillRect(180, 424 - 30, 46, 2);

        // left of cup
        g.fillArc(180, 398 - 30, 25, 55, 180, 90);
        // right of cup
        g.fillArc(200, 398 - 30, 25, 55, 270, 90);
        // under of cup
        g.fillRect(193, 454 - 30, 20, -30);

        g.fillRect(190, 424 - 30, 25, 30);
        // eye
        g.setColor(Color.red);
        g.fillRect(210, 430 - 30, 2, 2);
        g.fillRect(190, 430 - 30, 2, 2);

        // lip
        g.drawArc(197, 440 - 30, 10, 10, 180, 180);
    }

    private void mattress(Graphics g) {
        g.setColor(Color.decode("#6F4E25"));
        // g.drawArc(220, 530, 200, 5, 0, 100);

        g.drawArc(330, 530, 100, 30, 0, 180); // line top
        g.drawArc(330, 525, 30, 40, 180, 30); // line left
        g.drawArc(332, 540, 100, 30, 180, 180); // line bottom
        g.drawArc(427, 545, 5, 15, 270, 180); // line bottom
        // g.drawRect(427, 545, 10, 10);

    }

    public static void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
        double dx = Math.abs(x2 - x1);
        double dy = Math.abs(y2 - y1);

        double sx = (x1 < x2) ? 1 : -1;
        double sy = (y1 < y2) ? 1 : -1;
        boolean isSwap = false;
        if (dy > dx) {
            double tmp = dy;
            dy = dx;
            dx = tmp;
            isSwap = true;
        }

        double D = 2 * dy - dx;

        int x = x1;
        int y = y1;

        for (int i = 1; i <= dx; i++) {
            plot(g, x, y, 1);
            if (D >= 0) {
                if (isSwap)
                    x += sx;
                else
                    y += sy;

                D -= 2 * dx;
            }

            if (isSwap)
                y += sy;
            else
                x += sx;

            D += 2 * dy;
        }
    }

    public void bezier_Curve(Graphics g,int[] controlsPointX, int[] controlsPointY) {
        double t = 0;
        int xt;
        int yt;
        if(controlsPointX.length == 4){
            for (; t <= 1; t+= 0.001) {
             xt = (int) (Math.pow(1 - t, 3) * controlsPointX[0] +
                    3 * t * Math.pow(1 - t, 2) * controlsPointX[1] +
                    3 * t * t * Math.pow(1 - t, 1) * controlsPointX[2] +
                    t * t * t * controlsPointX[3]);

            yt = (int) (Math.pow(1 - t, 3) * controlsPointY[0] +
                    3 * t * Math.pow(1 - t, 2) * controlsPointY[1] +
                    3 * t * t * Math.pow(1 - t, 1) * controlsPointY[2] +
                    t * t * t * controlsPointY[3]);
  
                    plot(g, xt, yt);
            }
        }
        else{
            // System.out.println(" 8");
             for (; t <= 1; t+= 0.001) {
             xt = (int) (Math.pow(1 - t, 2) * controlsPointX[0] +
                    2 * t * Math.pow(1 - t, 1) * controlsPointX[1] +
                    t *  t * controlsPointX[2]);

            yt = (int) (Math.pow(1 - t, 2) * controlsPointY[0] +
                    2 * t * Math.pow(1 - t, 1) * controlsPointY[1] +
                    t  * t * controlsPointY[2]);
  
                    plot(g, xt, yt);
        }
        

    }
    }

    public static void plot(Graphics g, int x, int y, int size) {
        g.fillRect(x, y, size, size);
    }

    public static BufferedImage floodFill(BufferedImage m, int x, int y, Color target_color, Color replacement_color) {
        Queue<int[]> q = new LinkedList<>();
        // Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });
        int targetRGB = target_color.getRGB();
        int replaceRGB = replacement_color.getRGB();

        int[] currentPos;
        while (!q.isEmpty()) {
            currentPos = q.poll();

            int x1 = currentPos[0];
            int y1 = currentPos[1];

            if (m.getRGB(x1, y1) == targetRGB) {
                m.setRGB(x1, y1, replaceRGB);
                // south
                if (isInBound(x1, y1 + 1) && m.getRGB(x1, y1 + 1) == targetRGB) {
                    q.add(new int[] { x1, y1 + 1 });
                    // System.out.println("firsy");
                }
                // north
                if (isInBound(x1, y1 - 1) && m.getRGB(x1, y1 - 1) == targetRGB) {
                    q.add(new int[] { x1, y1 - 1 });
                    // System.out.println("f2irsy");
                }
                // east
                if (isInBound(x1 + 1, y1) && m.getRGB(x1 + 1, y1) == targetRGB) {
                    q.add(new int[] { x1 + 1, y1 });
                    // System.out.println("f3irsy");
                }
                // west
                if (isInBound(x1 - 1, y1) && m.getRGB(x1 - 1, y1) == targetRGB) {
                    q.add(new int[] { x1 - 1, y1 });
                    // System.out.println("fir4sy");
                }
            }
        }

        return m;
    }

    public static BufferedImage floodFill(BufferedImage m, int x, int y, Color border_Color) {
        Queue<int[]> q = new LinkedList<>();
        // Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });
        int border_ColorRGB = border_Color.getRGB();

        int[] currentPos;
        while (!q.isEmpty()) {
            currentPos = q.poll();

            int x1 = currentPos[0];
            int y1 = currentPos[1];

            if (m.getRGB(x1, y1) != border_ColorRGB) {
                m.setRGB(x1, y1, border_ColorRGB);
                // south
                if (isInBound(x1, y1 + 1) && m.getRGB(x1, y1 + 1) != border_ColorRGB) {
                    q.add(new int[] { x1, y1 + 1 });
                    // System.out.println("firsy");
                }
                // north
                if (isInBound(x1, y1 - 1) && m.getRGB(x1, y1 - 1) != border_ColorRGB) {
                    q.add(new int[] { x1, y1 - 1 });
                    // System.out.println("f2irsy");
                }
                // east
                if (isInBound(x1 + 1, y1) && m.getRGB(x1 + 1, y1) != border_ColorRGB) {
                    q.add(new int[] { x1 + 1, y1 });
                    // System.out.println("f3irsy");
                }
                // west
                if (isInBound(x1 - 1, y1) && m.getRGB(x1 - 1, y1) != border_ColorRGB) {
                    q.add(new int[] { x1 - 1, y1 });
                    // System.out.println("fir4sy");
                }
            }
        }

        return m;
    }

    static boolean isInBound(int x, int y) {
        return x >= 0 && y > 0 && x < 601 && y < 601;
    }
}