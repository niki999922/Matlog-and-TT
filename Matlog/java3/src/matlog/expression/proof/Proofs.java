package matlog.expression.proof;

import java.util.*;

/**
 * @author Kochetkov Nikita M3234
 * Date: 23.04.2019
 */
public class Proofs {
    public Map<String, List<String>> proofs = new HashMap<>();

    /**
     * first = operation
     * second = var
     * third = var
     */
    public Proofs() {
        proofs.put("00", generate00());
        proofs.put("01", generate01());

        proofs.put("100", generate100());
        proofs.put("101", generate101());
        proofs.put("110", generate110());
        proofs.put("111", generate111());

        proofs.put("200", generate200());
        proofs.put("201", generate201());
        proofs.put("210", generate210());
        proofs.put("211", generate211());

        proofs.put("300", generate300());
        proofs.put("301", generate301());
        proofs.put("310", generate310());
        proofs.put("311", generate311());

        proofs.put("ax", generateax());
        proofs.put("mp", generatemp());
        proofs.put("se", generatese());
        proofs.put("tl", generatetl());
    }
//list.add("
    //");

    private List<String> generate00() {
        List<String> list = new ArrayList<>();
        list.add("!(A)");
        return list;
        //StringJoiner stringJoiner = new StringJoiner(System.lineSeparator(),"",System.lineSeparator());

    }

    private List<String> generate01() {
        List<String> list = new ArrayList<>();
        list.add("(A)");
        list.add("(A)->(!!!(A)->(A))");
        list.add("!!!(A)->(A)");
        list.add("!!!(A)->!(A)");
        list.add("(!!!(A)->(A))->((!!!(A)->!(A))->!!!!(A))");
        list.add("(!!!(A)->!(A))->!!!!(A)");
        list.add("!!!!(A)");
        list.add("!!!!(A)->!!(A)");
        list.add("!!(A)");
        return list;
    }


    private List<String> generate100() {
        List<String> list = new ArrayList<>();
        list.add("!(A)");
        list.add("(!(A)->((A)->!(A)))");
        list.add("((A)->!(A))");
        list.add("!(B)");
        list.add("(!(B)->((A)->!(B)))");
        list.add("((A)->!(B))");
        list.add("((A)->((A)->(A)))");
        list.add("((A)->(((A)->(A))->(A)))");
        list.add("(((A)->((A)->(A)))->(((A)->(((A)->(A))->(A)))->((A)->(A))))");
        list.add("(((A)->(((A)->(A))->(A)))->((A)->(A)))");
        list.add("((A)->(A))");
        list.add("((!(B)->(A))->((!(B)->!(A))->!!(B)))");
        list.add("(((!(B)->(A))->((!(B)->!(A))->!!(B)))->((A)->((!(B)->(A))->((!(B)->!(A))->!!(B)))))");
        list.add("((A)->((!(B)->(A))->((!(B)->!(A))->!!(B))))");
        list.add("((A)->(!(B)->(A)))");
        list.add("(((A)->(!(B)->(A)))->((A)->((A)->(!(B)->(A)))))");
        list.add("((A)->((A)->(!(B)->(A))))");
        list.add("(((A)->(A))->(((A)->((A)->(!(B)->(A))))->((A)->(!(B)->(A)))))");
        list.add("(((A)->((A)->(!(B)->(A))))->((A)->(!(B)->(A))))");
        list.add("((A)->(!(B)->(A)))");
        list.add("(!(A)->(!(B)->!(A)))");
        list.add("((!(A)->(!(B)->!(A)))->((A)->(!(A)->(!(B)->!(A)))))");
        list.add("((A)->(!(A)->(!(B)->!(A))))");
        list.add("(((A)->!(A))->(((A)->(!(A)->(!(B)->!(A))))->((A)->(!(B)->!(A)))))");
        list.add("(((A)->(!(A)->(!(B)->!(A))))->((A)->(!(B)->!(A))))");
        list.add("((A)->(!(B)->!(A)))");
        list.add("(((A)->(!(B)->(A)))->(((A)->((!(B)->(A))->((!(B)->!(A))->!!(B))))->((A)->((!(B)->!(A))->!!(B)))))");
        list.add("(((A)->((!(B)->(A))->((!(B)->!(A))->!!(B))))->((A)->((!(B)->!(A))->!!(B))))");
        list.add("((A)->((!(B)->!(A))->!!(B)))");
        list.add("(((A)->(!(B)->!(A)))->(((A)->((!(B)->!(A))->!!(B)))->((A)->!!(B))))");
        list.add("(((A)->((!(B)->!(A))->!!(B)))->((A)->!!(B)))");
        list.add("((A)->!!(B))");
        list.add("(!!(B)->(B))");
        list.add("((!!(B)->(B))->((A)->(!!(B)->(B))))");
        list.add("((A)->(!!(B)->(B)))");
        list.add("(((A)->!!(B))->(((A)->(!!(B)->(B)))->((A)->(B))))");
        list.add("(((A)->(!!(B)->(B)))->((A)->(B)))");
        list.add("((A)->(B))");
        return list;
    }

    private List<String> generate101() {
        List<String> list = new ArrayList<>();
        list.add("(B)->((A)->(B))");
        list.add("(B)");
        list.add("(A)->(B)");
        return list;
    }

    private List<String> generate110() {
        List<String> list = new ArrayList<>();
        list.add("(A)");
        list.add("!(B)");
        list.add("!(B)->(((A)->(B))->!(B))");
        list.add("((A)->(B))->!(B)");
        list.add("((A)->(((A)->(B))->(A)))");
        list.add("(((A)->(B))->(A))");
        list.add("(((A)->(B))->(((A)->(B))->((A)->(B))))");
        list.add("((((A)->(B))->(((A)->(B))->((A)->(B))))->((((A)->(B))->((((A)->(B))->((A)->(B)))->((A)->(B))))->(((A)->(B))->((A)->(B)))))");
        list.add("((((A)->(B))->((((A)->(B))->((A)->(B)))->((A)->(B))))->(((A)->(B))->((A)->(B))))");
        list.add("(((A)->(B))->((((A)->(B))->((A)->(B)))->((A)->(B))))");
        list.add("(((A)->(B))->((A)->(B)))");
        list.add("((((A)->(B))->(A))->((((A)->(B))->((A)->(B)))->(((A)->(B))->(B))))");
        list.add("((((A)->(B))->((A)->(B)))->(((A)->(B))->(B)))");
        list.add("(((A)->(B))->(B))");
        list.add("(((A)->(B))->(B))->((((A)->(B))->!(B))->!((A)->(B)))");
        list.add("(((A)->(B))->!(B))->!((A)->(B))");
        list.add("!((A)->(B))");
        return list;
    }

    private List<String> generate111() {
        List<String> list = new ArrayList<>();
        list.add("(B)->((A)->(B))");
        list.add("(B)");
        list.add("(A)->(B)");
        return list;
    }



    private List<String> generate200() {
        List<String> list = new ArrayList<>();
        list.add("((A)&(B))->(A)");
        list.add("!(A)");
        list.add("!(A)->(((A)&(B))->!(A))");
        list.add("((A)&(B))->!(A)");
        list.add("(((A)&(B))->(A))->((((A)&(B))->!(A))->!((A)&(B)))");
        list.add("(((A)&(B))->!(A))->!((A)&(B))");
        list.add("!((A)&(B))");
        return list;
    }

    private List<String> generate201() {
        List<String> list = new ArrayList<>();
        list.add("((A)&(B))->(A)");
        list.add("!(A)->(((A)&(B))->!(A))");
        list.add("!(A)");
        list.add("((A)&(B))->!(A)");
        list.add("(((A)&(B))->(A))->((((A)&(B))->!(A))->!((A)&(B)))");
        list.add("(((A)&(B))->!(A))->!((A)&(B))");
        list.add("!((A)&(B))");
        return list;
    }

    private List<String> generate210() {
        List<String> list = new ArrayList<>();
        list.add("((A)&(B))->(B)");
        list.add("!(B)");
        list.add("!(B)->(((A)&(B))->!(B))");
        list.add("((A)&(B))->!(B)");
        list.add("(((A)&(B))->(B))->((((A)&(B))->!(B))->!((A)&(B)))");
        list.add("(((A)&(B))->!(B))->!((A)&(B))");
        list.add("!((A)&(B))");
        return list;
    }

    private List<String> generate211() {
        List<String> list = new ArrayList<>();
        list.add("(A)");
        list.add("(B)");
        list.add("(A)->((B)->((A)&(B)))");
        list.add("(B)->((A)&(B))");
        list.add("(A)&(B)");
        return list;
    }


    private List<String> generate300() {
        List<String> list = new ArrayList<>();
        list.add("!(A)");
        list.add("!(B)");
        list.add("((((A) | (B)) -> (A)) -> ((((A) | (B)) -> !(A)) -> !((A) | (B))))");
        list.add("(!(A) -> (((A) | (B)) -> !(A)))");
        list.add("(((A) | (B)) -> !(A))");
        list.add("(!(B) -> (((A) | (B)) -> !(B)))");
        list.add("(((A) | (B)) -> !(B))");
        list.add("(((A) | (B)) -> (((A) | (B)) -> ((A) | (B))))");
        list.add("(((A) | (B)) -> ((((A) | (B)) -> ((A) | (B))) -> ((A) | (B))))");
        list.add("((((A) | (B)) -> (((A) | (B)) -> ((A) | (B)))) -> ((((A) | (B)) -> ((((A) | (B)) -> ((A) | (B))) -> ((A) | (B)))) -> (((A) | (B)) -> ((A) | (B)))))");
        list.add("((((A) | (B)) -> ((((A) | (B)) -> ((A) | (B))) -> ((A) | (B)))) -> (((A) | (B)) -> ((A) | (B))))");
        list.add("(((A) | (B)) -> ((A) | (B)))");
        list.add("((A) -> ((A) -> (A)))");
        list.add("(((A) -> ((A) -> (A))) -> (((A) | (B)) -> ((A) -> ((A) -> (A)))))");
        list.add("(((A) | (B)) -> ((A) -> ((A) -> (A))))");
        list.add("(((A) -> ((A) -> (A))) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A))))");
        list.add("((((A) -> ((A) -> (A))) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A)))) -> (((A) | (B)) -> (((A) -> ((A) -> (A))) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A))))))");
        list.add("(((A) | (B)) -> (((A) -> ((A) -> (A))) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A)))))");
        list.add("((A) -> (((A) -> (A)) -> (A)))");
        list.add("(((A) -> (((A) -> (A)) -> (A))) -> (((A) | (B)) -> ((A) -> (((A) -> (A)) -> (A)))))");
        list.add("(((A) | (B)) -> ((A) -> (((A) -> (A)) -> (A))))");
        list.add("((((A) | (B)) -> ((A) -> ((A) -> (A)))) -> ((((A) | (B)) -> (((A) -> ((A) -> (A))) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A))))) -> (((A) | (B)) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A))))))");
        list.add("((((A) | (B)) -> (((A) -> ((A) -> (A))) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A))))) -> (((A) | (B)) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A)))))");
        list.add("(((A) | (B)) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A))))");
        list.add("((((A) | (B)) -> ((A) -> (((A) -> (A)) -> (A)))) -> ((((A) | (B)) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A)))) -> (((A) | (B)) -> ((A) -> (A)))))");
        list.add("((((A) | (B)) -> (((A) -> (((A) -> (A)) -> (A))) -> ((A) -> (A)))) -> (((A) | (B)) -> ((A) -> (A))))");
        list.add("(((A) | (B)) -> ((A) -> (A)))");
        list.add("(!(B) -> ((B) -> !(B)))");
        list.add("((!(B) -> ((B) -> !(B))) -> (((A) | (B)) -> (!(B) -> ((B) -> !(B)))))");
        list.add("(((A) | (B)) -> (!(B) -> ((B) -> !(B))))");
        list.add("((((A) | (B)) -> !(B)) -> ((((A) | (B)) -> (!(B) -> ((B) -> !(B)))) -> (((A) | (B)) -> ((B) -> !(B)))))");
        list.add("((((A) | (B)) -> (!(B) -> ((B) -> !(B)))) -> (((A) | (B)) -> ((B) -> !(B))))");
        list.add("(((A) | (B)) -> ((B) -> !(B)))");
        list.add("((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))");
        list.add("(((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> (((A) | (B)) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))");
        list.add("(((A) | (B)) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))))");
        list.add("(((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))");
        list.add("((((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))))) -> (((A) | (B)) -> (((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))))");
        list.add("(((A) | (B)) -> (((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))))))");
        list.add("((((A) | (B)) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((((A) | (B)) -> (((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))) -> (((A) | (B)) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))))");
        list.add("((((A) | (B)) -> (((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))) -> (((A) | (B)) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))))))");
        list.add("(((A) | (B)) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))))");
        list.add("((B) -> (!(A) -> (B)))");
        list.add("(((B) -> (!(A) -> (B))) -> (((A) | (B)) -> ((B) -> (!(A) -> (B)))))");
        list.add("(((A) | (B)) -> ((B) -> (!(A) -> (B))))");
        list.add("(!(B) -> (!(A) -> !(B)))");
        list.add("((!(B) -> (!(A) -> !(B))) -> (((A) | (B)) -> (!(B) -> (!(A) -> !(B)))))");
        list.add("(((A) | (B)) -> (!(B) -> (!(A) -> !(B))))");
        list.add("((!(B) -> (!(A) -> !(B))) -> ((B) -> (!(B) -> (!(A) -> !(B)))))");
        list.add("(((!(B) -> (!(A) -> !(B))) -> ((B) -> (!(B) -> (!(A) -> !(B))))) -> (((A) | (B)) -> ((!(B) -> (!(A) -> !(B))) -> ((B) -> (!(B) -> (!(A) -> !(B)))))))");
        list.add("(((A) | (B)) -> ((!(B) -> (!(A) -> !(B))) -> ((B) -> (!(B) -> (!(A) -> !(B))))))");
        list.add("((((A) | (B)) -> (!(B) -> (!(A) -> !(B)))) -> ((((A) | (B)) -> ((!(B) -> (!(A) -> !(B))) -> ((B) -> (!(B) -> (!(A) -> !(B)))))) -> (((A) | (B)) -> ((B) -> (!(B) -> (!(A) -> !(B)))))))");
        list.add("((((A) | (B)) -> ((!(B) -> (!(A) -> !(B))) -> ((B) -> (!(B) -> (!(A) -> !(B)))))) -> (((A) | (B)) -> ((B) -> (!(B) -> (!(A) -> !(B))))))");
        list.add("(((A) | (B)) -> ((B) -> (!(B) -> (!(A) -> !(B)))))");
        list.add("(((B) -> !(B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B)))))");
        list.add("((((B) -> !(B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B))))) -> (((A) | (B)) -> (((B) -> !(B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B)))))))");
        list.add("(((A) | (B)) -> (((B) -> !(B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B))))))");
        list.add("((((A) | (B)) -> ((B) -> !(B))) -> ((((A) | (B)) -> (((B) -> !(B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B)))))) -> (((A) | (B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B)))))))");
        list.add("((((A) | (B)) -> (((B) -> !(B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B)))))) -> (((A) | (B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B))))))");
        list.add("(((A) | (B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B)))))");
        list.add("((((A) | (B)) -> ((B) -> (!(B) -> (!(A) -> !(B))))) -> ((((A) | (B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B))))) -> (((A) | (B)) -> ((B) -> (!(A) -> !(B))))))");
        list.add("((((A) | (B)) -> (((B) -> (!(B) -> (!(A) -> !(B)))) -> ((B) -> (!(A) -> !(B))))) -> (((A) | (B)) -> ((B) -> (!(A) -> !(B)))))");
        list.add("(((A) | (B)) -> ((B) -> (!(A) -> !(B))))");
        list.add("(((B) -> (!(A) -> (B))) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))");
        list.add("((((B) -> (!(A) -> (B))) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))) -> (((A) | (B)) -> (((B) -> (!(A) -> (B))) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))))");
        list.add("(((A) | (B)) -> (((B) -> (!(A) -> (B))) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))))");
        list.add("((((A) | (B)) -> ((B) -> (!(A) -> (B)))) -> ((((A) | (B)) -> (((B) -> (!(A) -> (B))) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))) -> (((A) | (B)) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))))");
        list.add("((((A) | (B)) -> (((B) -> (!(A) -> (B))) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))) -> (((A) | (B)) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))))");
        list.add("(((A) | (B)) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))");
        list.add("((((A) | (B)) -> ((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A))))) -> ((((A) | (B)) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))) -> (((A) | (B)) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))))");
        list.add("((((A) | (B)) -> (((B) -> ((!(A) -> (B)) -> ((!(A) -> !(B)) -> !!(A)))) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))) -> (((A) | (B)) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))))");
        list.add("(((A) | (B)) -> ((B) -> ((!(A) -> !(B)) -> !!(A))))");
        list.add("(((B) -> (!(A) -> !(B))) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A))))");
        list.add("((((B) -> (!(A) -> !(B))) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A)))) -> (((A) | (B)) -> (((B) -> (!(A) -> !(B))) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A))))))");
        list.add("(((A) | (B)) -> (((B) -> (!(A) -> !(B))) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A)))))");
        list.add("((((A) | (B)) -> ((B) -> (!(A) -> !(B)))) -> ((((A) | (B)) -> (((B) -> (!(A) -> !(B))) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A))))) -> (((A) | (B)) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A))))))");
        list.add("((((A) | (B)) -> (((B) -> (!(A) -> !(B))) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A))))) -> (((A) | (B)) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A)))))");
        list.add("(((A) | (B)) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A))))");
        list.add("((((A) | (B)) -> ((B) -> ((!(A) -> !(B)) -> !!(A)))) -> ((((A) | (B)) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A)))) -> (((A) | (B)) -> ((B) -> !!(A)))))");
        list.add("((((A) | (B)) -> (((B) -> ((!(A) -> !(B)) -> !!(A))) -> ((B) -> !!(A)))) -> (((A) | (B)) -> ((B) -> !!(A))))");
        list.add("(((A) | (B)) -> ((B) -> !!(A)))");
        list.add("(!!(A) -> (A))");
        list.add("((!!(A) -> (A)) -> (((A) | (B)) -> (!!(A) -> (A))))");
        list.add("(((A) | (B)) -> (!!(A) -> (A)))");
        list.add("((!!(A) -> (A)) -> ((B) -> (!!(A) -> (A))))");
        list.add("(((!!(A) -> (A)) -> ((B) -> (!!(A) -> (A)))) -> (((A) | (B)) -> ((!!(A) -> (A)) -> ((B) -> (!!(A) -> (A))))))");
        list.add("(((A) | (B)) -> ((!!(A) -> (A)) -> ((B) -> (!!(A) -> (A)))))");
        list.add("((((A) | (B)) -> (!!(A) -> (A))) -> ((((A) | (B)) -> ((!!(A) -> (A)) -> ((B) -> (!!(A) -> (A))))) -> (((A) | (B)) -> ((B) -> (!!(A) -> (A))))))");
        list.add("((((A) | (B)) -> ((!!(A) -> (A)) -> ((B) -> (!!(A) -> (A))))) -> (((A) | (B)) -> ((B) -> (!!(A) -> (A)))))");
        list.add("(((A) | (B)) -> ((B) -> (!!(A) -> (A))))");
        list.add("(((B) -> !!(A)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A))))");
        list.add("((((B) -> !!(A)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A)))) -> (((A) | (B)) -> (((B) -> !!(A)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A))))))");
        list.add("(((A) | (B)) -> (((B) -> !!(A)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A)))))");
        list.add("((((A) | (B)) -> ((B) -> !!(A))) -> ((((A) | (B)) -> (((B) -> !!(A)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A))))) -> (((A) | (B)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A))))))");
        list.add("((((A) | (B)) -> (((B) -> !!(A)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A))))) -> (((A) | (B)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A)))))");
        list.add("(((A) | (B)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A))))");
        list.add("((((A) | (B)) -> ((B) -> (!!(A) -> (A)))) -> ((((A) | (B)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A)))) -> (((A) | (B)) -> ((B) -> (A)))))");
        list.add("((((A) | (B)) -> (((B) -> (!!(A) -> (A))) -> ((B) -> (A)))) -> (((A) | (B)) -> ((B) -> (A))))");
        list.add("(((A) | (B)) -> ((B) -> (A)))");
        list.add("(((A) -> (A)) -> (((B) -> (A)) -> (((A) | (B)) -> (A))))");
        list.add("((((A) -> (A)) -> (((B) -> (A)) -> (((A) | (B)) -> (A)))) -> (((A) | (B)) -> (((A) -> (A)) -> (((B) -> (A)) -> (((A) | (B)) -> (A))))))");
        list.add("(((A) | (B)) -> (((A) -> (A)) -> (((B) -> (A)) -> (((A) | (B)) -> (A)))))");
        list.add("((((A) | (B)) -> ((A) -> (A))) -> ((((A) | (B)) -> (((A) -> (A)) -> (((B) -> (A)) -> (((A) | (B)) -> (A))))) -> (((A) | (B)) -> (((B) -> (A)) -> (((A) | (B)) -> (A))))))");
        list.add("((((A) | (B)) -> (((A) -> (A)) -> (((B) -> (A)) -> (((A) | (B)) -> (A))))) -> (((A) | (B)) -> (((B) -> (A)) -> (((A) | (B)) -> (A)))))");
        list.add("(((A) | (B)) -> (((B) -> (A)) -> (((A) | (B)) -> (A))))");
        list.add("((((A) | (B)) -> ((B) -> (A))) -> ((((A) | (B)) -> (((B) -> (A)) -> (((A) | (B)) -> (A)))) -> (((A) | (B)) -> (((A) | (B)) -> (A)))))");
        list.add("((((A) | (B)) -> (((B) -> (A)) -> (((A) | (B)) -> (A)))) -> (((A) | (B)) -> (((A) | (B)) -> (A))))");
        list.add("(((A) | (B)) -> (((A) | (B)) -> (A)))");
        list.add("((((A) | (B)) -> ((A) | (B))) -> ((((A) | (B)) -> (((A) | (B)) -> (A))) -> (((A) | (B)) -> (A))))");
        list.add("((((A) | (B)) -> (((A) | (B)) -> (A))) -> (((A) | (B)) -> (A)))");
        list.add("(((A) | (B)) -> (A))");
        list.add("((((A) | (B)) -> !(A)) -> !((A) | (B)))");
        list.add("!((A) | (B))");
        return list;
    }

    private List<String> generate301() {
        List<String> list = new ArrayList<>();
        list.add("(B)");
        list.add("(B)->((A)|(B))");
        list.add("(A)|(B)");
        return list;
    }

    private List<String> generate310() {
        List<String> list = new ArrayList<>();
        list.add("(A)");
        list.add("(A)->((A)|(B))");
        list.add("(A)|(B)");
        return list;
    }

    private List<String> generate311() {
        List<String> list = new ArrayList<>();
        list.add("(A)");
        list.add("(A)->((A)|(B))");
        list.add("(A)|(B)");
        return list;
    }


    private List<String> generateax() {
        List<String> list = new ArrayList<>();
        list.add("(A)->((B)->(A))");
        list.add("(A)");
        list.add("(B)->(A)");
        return list;
    }

    private List<String> generatemp() {
        List<String> list = new ArrayList<>();
        list.add("((A)->(B))->(((A)->((B)->(C)))->((A)->(C)))");
        list.add("((A)->((B)->(C)))->((A)->(C))");
        list.add("(A)->(C)");
        return list;
    }

    private List<String> generatese() {
        List<String> list = new ArrayList<>();
        list.add("(A)->((A)->(A))");
        list.add("((A)->((A)->(A)))->(((A)->(((A)->(A))->(A)))->((A)->(A)))");
        list.add("(A)->(((A)->(A))->(A))");
        list.add("((A)->(((A)->(A))->(A)))->((A)->(A))");
        list.add("(A)->(A)");
        return list;
    }

    private List<String> generatetl() {
        List<String> list = new ArrayList<>();
        list.add("(B)->((B)|!(B))");
        list.add("(!((B)|!(B))->((B)->!((B)|!(B))))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B)))");
        list.add("((!((B)|!(B))->((B)->!((B)|!(B))))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B))))->(((B)->((B)|!(B)))->((!((B)|!(B))->((B)->!((B)|!(B))))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B)))))");
        list.add("((B)->((B)|!(B)))->((!((B)|!(B))->((B)->!((B)|!(B))))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B))))");
        list.add("!((B)|!(B))->((B)->!((B)|!(B)))");
        list.add("(!((B)|!(B))->((B)->!((B)|!(B))))->(((B)->((B)|!(B)))->(!((B)|!(B))->((B)->!((B)|!(B)))))");
        list.add("((B)->((B)|!(B)))->(!((B)|!(B))->((B)->!((B)|!(B))))");
        list.add("(((B)->((B)|!(B)))->(!((B)|!(B))->((B)->!((B)|!(B)))))->((((B)->((B)|!(B)))->((!((B)|!(B))->((B)->!((B)|!(B))))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B)))))->(((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B)))))");
        list.add("(((B)->((B)|!(B)))->((!((B)|!(B))->((B)->!((B)|!(B))))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B)))))->(((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B))))");
        list.add("((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B)))");
        list.add("(!((B)|!(B))->((B)->((B)|!(B))))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))");
        list.add("((!((B)|!(B))->((B)->((B)|!(B))))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))))->(((B)->((B)|!(B)))->((!((B)|!(B))->((B)->((B)|!(B))))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))))");
        list.add("((B)->((B)|!(B)))->((!((B)|!(B))->((B)->((B)|!(B))))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))))");
        list.add("((B)->((B)|!(B)))->(!((B)|!(B))->((B)->((B)|!(B))))");
        list.add("(((B)->((B)|!(B)))->(!((B)|!(B))->((B)->((B)|!(B)))))->((((B)->((B)|!(B)))->((!((B)|!(B))->((B)->((B)|!(B))))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))))->(((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))))");
        list.add("(((B)->((B)|!(B)))->((!((B)|!(B))->((B)->((B)|!(B))))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))))->(((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))))");
        list.add("((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))");
        list.add("(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))");
        list.add("((((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))))->(((B)->((B)|!(B)))->((((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))))");
        list.add("((B)->((B)|!(B)))->((((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))))");
        list.add("((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))");
        list.add("(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(((B)->((B)|!(B)))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))");
        list.add("((B)->((B)|!(B)))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))");
        list.add("(((B)->((B)|!(B)))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->((((B)->((B)|!(B)))->((((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))))->(((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))))");
        list.add("(((B)->((B)|!(B)))->((((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))))->(((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))))");
        list.add("((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))");
        list.add("(((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B)))))->((((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))))->(((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))))");
        list.add("(((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->((B)|!(B)))->(((B)->!((B)|!(B)))->!(B))))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))))->(((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))");
        list.add("((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))");
        list.add("(((B)->((B)|!(B)))->(!((B)|!(B))->(((B)->!((B)|!(B)))->!(B))))->((((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B))))->(((B)->((B)|!(B)))->(!((B)|!(B))->!(B))))");
        list.add("(((B)->((B)|!(B)))->((!((B)|!(B))->(((B)->!((B)|!(B)))->!(B)))->(!((B)|!(B))->!(B))))->(((B)->((B)|!(B)))->(!((B)|!(B))->!(B)))");
        list.add("((B)->((B)|!(B)))->(!((B)|!(B))->!(B))");
        list.add("!((B)|!(B))->!(B)");
        list.add("!(B)->((B)|!(B))");
        list.add("(!((B)|!(B))->(!(B)->!((B)|!(B))))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B)))");
        list.add("((!((B)|!(B))->(!(B)->!((B)|!(B))))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B))))->((!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->!((B)|!(B))))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B)))))");
        list.add("(!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->!((B)|!(B))))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B))))");
        list.add("!((B)|!(B))->(!(B)->!((B)|!(B)))");
        list.add("(!((B)|!(B))->(!(B)->!((B)|!(B))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->(!(B)->!((B)|!(B)))))");
        list.add("(!(B)->((B)|!(B)))->(!((B)|!(B))->(!(B)->!((B)|!(B))))");
        list.add("((!(B)->((B)|!(B)))->(!((B)|!(B))->(!(B)->!((B)|!(B)))))->(((!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->!((B)|!(B))))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B)))))->((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B)))))");
        list.add("((!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->!((B)|!(B))))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B)))))->((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B))))");
        list.add("(!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B)))");
        list.add("(!((B)|!(B))->(!(B)->((B)|!(B))))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))");
        list.add("((!((B)|!(B))->(!(B)->((B)|!(B))))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))))->((!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->((B)|!(B))))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))))");
        list.add("(!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->((B)|!(B))))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))))");
        list.add("(!(B)->((B)|!(B)))->(!((B)|!(B))->(!(B)->((B)|!(B))))");
        list.add("((!(B)->((B)|!(B)))->(!((B)|!(B))->(!(B)->((B)|!(B)))))->(((!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->((B)|!(B))))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))))->((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))))");
        list.add("((!(B)->((B)|!(B)))->((!((B)|!(B))->(!(B)->((B)|!(B))))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))))->((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))))");
        list.add("(!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))");
        list.add("((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))");
        list.add("(((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))))->((!(B)->((B)|!(B)))->(((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))))");
        list.add("(!(B)->((B)|!(B)))->(((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))))");
        list.add("(!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))");
        list.add("((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->((!(B)->((B)|!(B)))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))");
        list.add("(!(B)->((B)|!(B)))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))");
        list.add("((!(B)->((B)|!(B)))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(((!(B)->((B)|!(B)))->(((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))))");
        list.add("((!(B)->((B)|!(B)))->(((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))))");
        list.add("(!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))");
        list.add("((!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B)))))->(((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))))");
        list.add("((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->((B)|!(B)))->((!(B)->!((B)|!(B)))->!!(B))))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))");
        list.add("(!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))");
        list.add("((!(B)->((B)|!(B)))->(!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B))))->(((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->!!(B))))");
        list.add("((!(B)->((B)|!(B)))->((!((B)|!(B))->((!(B)->!((B)|!(B)))->!!(B)))->(!((B)|!(B))->!!(B))))->((!(B)->((B)|!(B)))->(!((B)|!(B))->!!(B)))");
        list.add("(!(B)->((B)|!(B)))->(!((B)|!(B))->!!(B))");
        list.add("(!((B)|!(B))->!!(B))");
        list.add("(!((B)|!(B))->!(B))->((!((B)|!(B))->!(!(B)))->!(!((B)|!(B))))");
        list.add("(!((B)|!(B))->!(!(B)))->!(!((B)|!(B)))");
        list.add("!(!((B)|!(B)))");
        list.add("!(!((B)|!(B)))->((B)|!(B))");
        list.add("(B)|!(B)");
        return list;
    }
}
