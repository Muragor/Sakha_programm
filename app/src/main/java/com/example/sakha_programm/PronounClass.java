package com.example.sakha_programm;

public class PronounClass extends Sakha_noun{

    @Override
    public String Dat_p(String w, int face, int count) {
        return super.Dat_p(w, face, count);
    }

    String pronoun_pad(int face, int count, int pad) {
        if (count == 1) {
            switch (face) {
                case 1:
                    switch (pad) {
                        case 0:
                            return "Мин";
                        case 1:
                            return "Миэхэ";
                        case 2:
                            return "Миигин";
                        case 3:
                            return "Миигиттэн";
                        case 4:
                            return "Миигинэн";
                        case 5:
                            return "Миигинниин";
                        default:
                            return "Миигиннээҕэр";
                    }

                case 2:
                    switch (pad) {
                        case 0:
                            return "Эн";
                        case 1:
                            return "Эйиэхэ";
                        case 2:
                            return "Эйигин";
                        case 3:
                            return "Эйигиттэн";
                        case 4:
                            return "Эйигинэн";
                        case 5:
                            return "Эйигинниин";
                        default:
                            return "Эйигиннээҕэр";
                    }
                default:
                    switch (pad) {
                        case 0:
                            return "Кини";
                        case 1:
                            return "Киниэхэ";
                        case 2:
                            return "Кинини";
                        case 3:
                            return "Киниттэн";
                        case 4:
                            return "Кининэн";
                        case 5:
                            return "Кинилиин";
                        default:
                            return "Кинитээҕэр";
                    }
            }
        }
        else {
            switch (face) {
                case 1:
                    switch (pad) {
                        case 0:
                            return "Биhиги";
                        case 1:
                            return "Биhиэхэ";
                        case 2:
                            return "Биhигини";
                        case 3:
                            return "Биhигиттэн";
                        case 4:
                            return "Биhигинэн";
                        case 5:
                            return "Биhигинниин";
                        default:
                            return "Биhигиннээҕэр";
                    }
                case 2:
                    switch (pad) {
                        case 0:
                            return "Эhиги";
                        case 1:
                            return "Эhиэхэ";
                        case 2:
                            return "Эhигини";
                        case 3:
                            return "Эhигиттэн";
                        case 4:
                            return "Эhигинэн";
                        case 5:
                            return "Эhигинниин";
                        default:
                            return "Эhигиннээҕэр";
                    }
                default:
                    switch (pad) {
                        case 0:
                            return "Кинилэр";
                        case 1:
                            return "Кинилэргэ";
                        case 2:
                            return "Кинилэри";
                        case 3:
                            return "Кинилэриттэн";
                        case 4:
                            return "Кинилэринэн";
                        case 5:
                            return "Кинилэрдиин";
                        default:
                            return "Кинилэрдээҕэр";
                    }
            }
        }
    }
    String pronoun_pad_2(int face, int count, int pad){
        Sakha_noun n = new Sakha_noun();
        if (count == 1) {
        switch (face) {
            case 1:
                switch (pad) {
                    case 0: return "Миэнэ";
                    case 1: return n.Dat_p("Миэн", 3, 1);
                    case 2: return n.Vin_p("Миэн", 3, 1);
                    case 3: return n.Ish_p("Миэн", 3, 1);
                    case 4: return n.Tvor_p("Миэн", 3, 1);
                    case 5: return n.Sovm_p("Миэн", 3, 1);
                    default: return n.Srav_p("Миэн", 3, 1);
                }
            case 2:
                switch (pad) {
                    case 0: return "Эйиэнэ";
                    case 1: return n.Dat_p("Эйиэн", 3, 1);
                    case 2: return n.Vin_p("Эйиэн", 3, 1);
                    case 3: return n.Ish_p("Эйиэн", 3, 1);
                    case 4: return n.Tvor_p("Эйиэн", 3, 1);
                    case 5: return n.Sovm_p("Эйиэн", 3, 1);
                    default: return n.Srav_p("Эйиэн", 3, 1);
                }

            default:
                switch (pad) {
                    case 0: return "Киниэнэ";
                    case 1: return n.Dat_p("Киниэн", 3, 1);
                    case 2: return n.Vin_p("Киниэн", 3, 1);
                    case 3: return n.Ish_p("Киниэн", 3, 1);
                    case 4: return n.Tvor_p("Киниэн", 3, 1);
                    case 5: return n.Sovm_p("Киниэн", 3, 1);
                    default: return n.Srav_p("Киниэн", 3, 1);
                }

        } }
        else {
            switch (face) {
                case 1:
                    switch (pad) {
                        case 0: return "Биhэнэ";
                        case 1: return n.Dat_p("Биhэн", 3, 1);
                        case 2: return n.Vin_p("Биhэн", 3, 1);
                        case 3: return n.Ish_p("Биhэн", 3, 1);
                        case 4: return n.Tvor_p("Биhэн", 3, 1);
                        case 5: return n.Sovm_p("Биhэн", 3, 1);
                        default: return n.Srav_p("Биhэн", 3, 1);
                    }

                case 2:
                    switch (pad) {
                        case 0: return "Эhиэнэ";
                        case 1: return n.Dat_p("Эhиэн", 3, 1);
                        case 2: return n.Vin_p("Эhиэн", 3, 1);
                        case 3: return n.Ish_p("Эhиэн", 3, 1);
                        case 4: return n.Tvor_p("Эhиэн", 3, 1);
                        case 5: return n.Sovm_p("Эhиэн", 3, 1);
                        default: return n.Srav_p("Эhиэн", 3, 1);
                    }

                default:
                    switch (pad) {
                        case 0: return "Кинилэр киэннэрэ";
                        case 1: return n.Dat_p("Кинилэр киэннэр", 3, 1);
                        case 2: return n.Vin_p("Кинилэр киэннэр", 3, 1);
                        case 3: return n.Ish_p("Кинилэр киэннэр", 3, 1);
                        case 4: return n.Tvor_p("Кинилэр киэннэр", 3, 1);
                        case 5: return n.Sovm_p("Кинилэр киэннэр", 3, 1);
                        default: return n.Srav_p("Кинилэр киэннэр", 3, 1);
                    }

            }
        }
    }



}
