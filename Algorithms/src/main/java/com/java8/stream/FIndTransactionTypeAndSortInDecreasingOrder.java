package com.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class FIndTransactionTypeAndSortInDecreasingOrder {
    public static void main(String[] args) {
        List<Transaction> groceryTransactions = new ArrayList<>();
        List<Transaction> transactions = getTransactions();

        for (Transaction transaction : transactions) {
            if (transaction.getType()==Transaction.GROCERY) {
                groceryTransactions.add(transaction);
            }
        }

        Collections.sort(groceryTransactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> transactionIds = new ArrayList<>();
        for(Transaction t: groceryTransactions){
            transactionIds.add(t.getId());
        }

        // same as above using stream

        transactions.stream()
                .filter(t->t.getType()==Transaction.GROCERY)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getId)
                .collect(Collectors.toList());

        // same as above using parallel stream

        transactions.parallelStream()
                .filter(t->t.getType()==Transaction.GROCERY)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .map(Transaction::getId)
                .collect(Collectors.toList());

    }

    private static List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("grocery", "mango", 1));

        return transactions;
    }

    static class Transaction {
        public static final String GROCERY = "grocery";
        String type;
        String value;
        Integer id;
        Transaction(String type, String value, Integer id) {
            this.type=type;
            this.value=value;
            this.id=id;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
