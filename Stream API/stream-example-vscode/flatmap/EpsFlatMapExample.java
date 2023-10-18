import java.util.*;
import java.util.stream.*;
import java.math.BigDecimal;

public class EpsFlatMapExample{

    public static void main(String [] args){
        List<EpsDto> magnificent7 = m7Fixture();
        List<EpsDto> restaurant7 = foodEpsFixture();
        List<EpsDto> sportsBrand = sportsApparelFixture();

        
        SectorLeadersDto m7Sector = 
            new SectorLeadersDto("magnificent 7", magnificent7);
            
        SectorLeadersDto restaurant7Sector = 
            new SectorLeadersDto("restaurant 7", restaurant7);

        SectorLeadersDto sportswearSector = 
            new SectorLeadersDto("sports wear", sportsBrand);
                
        Comparator<EpsDto> ascendingComparator =
            (left, right) -> left.getEps().compareTo(right.getEps());
                
        List<EpsDto> mergedEpsTop3 = Arrays.asList(
                m7Sector, 
                restaurant7Sector, 
                sportswearSector)
            .stream()
            .flatMap(sector -> sector.getEpsList().stream())
            .sorted(ascendingComparator.reversed())
            .limit(3)
            .peek(System.out::println)
            .collect(Collectors.toList());
        
        /* // 출력
            EpsDto [ticker = DPZ,eps = 13.22]
            EpsDto [ticker = MCD,eps = 10.85]
            EpsDto [ticker = MSFT,eps = 9.7]
         */
    }

    public static List<EpsDto> m7Fixture(){
        return Arrays.asList(
            new EpsDto("MSFT", BigDecimal.valueOf(9.70)),
            new EpsDto("AAPL", BigDecimal.valueOf(5.95)),
            new EpsDto("GOOG", BigDecimal.valueOf(4.72)),
            new EpsDto("AMZN", BigDecimal.valueOf(1.26)),
            new EpsDto("NVDA", BigDecimal.valueOf(4.13)),
            new EpsDto("TSLA", BigDecimal.valueOf(3.52)),
            new EpsDto("META", BigDecimal.valueOf(8.59))
        );
    }

    public static List<EpsDto> foodEpsFixture(){
        return Arrays.asList(
            new EpsDto("MCD", BigDecimal.valueOf(10.85)),
            new EpsDto("SBUX", BigDecimal.valueOf(3.28)),
            new EpsDto("PZZA", BigDecimal.valueOf(2.10)),
            new EpsDto("DPZ", BigDecimal.valueOf(13.22)),
            new EpsDto("YUM", BigDecimal.valueOf(4.94)),
            new EpsDto("TSLA", BigDecimal.valueOf(3.52)),
            new EpsDto("META", BigDecimal.valueOf(3.27))
        );
    }

    public static List<EpsDto> sportsApparelFixture(){
        return Arrays.asList(
            new EpsDto("NKE", BigDecimal.valueOf(3.24)),
            new EpsDto("AEO", BigDecimal.valueOf(1.04)),
            new EpsDto("UA", BigDecimal.valueOf(0.84))
        );
    }

    private static class SectorLeadersDto {
        private String sectorName;
        private List<EpsDto> epsList;

        public SectorLeadersDto(String sectorName, List<EpsDto> epsList){
            this.sectorName = sectorName;
            this.epsList = epsList;
        }

        public String getSectorName(){
            return this.sectorName;
        }

        public List<EpsDto> getEpsList(){
            return this.epsList;
        }

        @Override
        public String toString(){
            StringBuilder builder = new StringBuilder();
            builder
                .append("SectorLeadersDto [")
                .append("sectorName = ").append(sectorName).append(", ")
                .append("epsList = ").append("epsList")
                .append("]");
            return builder.toString();
        }
    }

    private static class EpsDto{
        private final String ticker;
        private final BigDecimal eps;

        public EpsDto(String ticker, BigDecimal eps){
            this.ticker = ticker;
            this.eps = eps;
        }

        public String getTicker(){
            return this.ticker;
        }

        public BigDecimal getEps(){
            return this.eps;
        }

        public String toString(){
            StringBuilder builder = new StringBuilder()
                .append("EpsDto [")
                .append("ticker = ").append(ticker).append(",")
                .append("eps = ").append(eps).append("")
                .append("]");
            
            return builder.toString();
        }
    }
}