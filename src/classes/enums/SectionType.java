package classes.enums;
import static classes.constants.AllConstants.*;

/**
 * Created by treve on 09.04.2018.
 */
public enum SectionType {

    TODAY {
        @Override
        public String getSomePage() {
            return TODAY_JSP;
        }

    },
    TOMORROW {
        @Override
        public String getSomePage() {
            return TOMORROW_JSP;
        }

    },
    SOMEDAY {
        @Override
        public String getSomePage() {
            return SOMEDAY_JSP;
        }

    },
    FIXED {
        @Override
        public String getSomePage() {
            return FIXED_JSP;
        }

    },
    RECYCLE_BIN {
        @Override
        public String getSomePage() {
            return RECYCLE_BIN_JSP;
        }

    };

    public abstract String getSomePage();


}
