package final_project;
import java.util.Date;
import java.util.Scanner;
public class POS_Emulator_FINAL {
	
		public static Scanner scn = new Scanner(System.in);
		
		
		public static int   milominiqty = 0,    milomidiqty = 0,    milomaxiqty = 0, //initialization for 1st drink quantity
							energenminiqty = 0, energenmidiqty = 0, energenmaxiqty = 0, //initialization for 2nd drink quantity
							kopikominiqty = 0,  kopikomidiqty = 0,  kopikomaxiqty = 0, //initialization for 3rd drink quantity
							pandesalqty = 0,    monayqty = 0,       putokqty = 0; //initialization for pastries quantity
		
		public static double milominiAmount = 0,    milomidiAmount = 0,    milomaxiAmount = 0, 
							 energenminiAmount = 0, energenmidiAmount = 0, energenmaxiAmount = 0, 
							 kopikominiAmount = 0,  kopikomidiAmount = 0,  kopikomaxiAmount = 0,
							 pandesalAmount = 0,    monayAmount = 0,       putokAmount = 0,
							 drinkstotal = 0, pastrytotal = 0; //initialization for total drinks & pastries ordered
		
		public static String[] drinks      = {"Milo","Energen","Kopiko"};
		public static String[] sizes       = {"Mini","Midi","Maxi"};
		public static double[] sizePrice   = {25.00,35.00,45.00};
		public static String[] pastry      = {"Pandesal","Monay","Putok"};
		public static double[] pastryPrice = {10.00,15.00,25.00};
		
		public static void decision() {
			System.out.println("\n1. Add Order\n2. View Orders\n3. Remove Item\n4. Cancel Transaction\n5. Checkout\n6. Exit");
		}
		
		public static void addOrder() {
			System.out.println("\nWhat would you like to order?\n1. Drinks\n2. Pastry\n");
				int order = scn.nextInt();
				
				switch (order) {
				case 1 : drinksMenu(); break;
				case 2 : pastryMenu(); break;
				default: System.out.println("Choose 1 or 2 only.");
						 addOrder();
				}
		}
		
		public static void drinksMenu() {
			System.out.println("\n-----------------\n     DRINKS\n-----------------\n1. Milo\n2. Energen\n3. Kopiko\n");
			drinks();
		}
		
		public static void sizes() {
			System.out.println("\n----------------\n      SIZES     \n-----------------\n1. Mini - ₱25.00\n2. Midi - ₱35.00\n3. Maxi - ₱45.00\n");
		}
		
		public static void drinks() { 
			System.out.print("Choose a drink: "); 
		    int drink = scn.nextInt(); 
		    if(drink > 3 || drink < 1) {
		    	System.out.println("Invalid order. Please try again."); 
		    	drinksMenu(); 
			}
				sizes();
				System.out.print("\nWhat size? "); 
		        int size = scn.nextInt();
			    if (size < 1 || size > 3) {
			    	System.out.println("Invalid size. ");
			    	drinksMenu();
				}
			    	if (drink == 1) { 
				        if (size >= 1 && size <= 3) { 
				            System.out.print("How many? "); 
				            int qty = scn.nextInt(); 
				            drinkstotal = qty * sizePrice[size - 1]; // adjust for 0-based index 
				            System.out.println("Added order: " + qty + " " + drinks[0] + " (Size: " + sizes[size - 1] + ") = " + drinkstotal); 
				            switch (size) {
				                case 1: milominiqty += qty; milominiAmount += drinkstotal; break;
				                case 2: milomidiqty += qty; milomidiAmount += drinkstotal; break;
				                case 3: milomaxiqty += qty; milomaxiAmount += drinkstotal; break;
				            }
				        } 
				    } else if (drink == 2) {
				        if (size >= 1 && size <= 3) { 
				            System.out.print("How many? "); 
				            int qty = scn.nextInt(); 
				            drinkstotal = qty * sizePrice[size - 1]; // adjust for 0-based index
				            System.out.println("Added order: " + qty + " " + drinks[1] + " (Size: " + sizes[size - 1] + ") = " + drinkstotal); 
				            switch (size) {
				                case 1: energenminiqty += qty; energenminiAmount += drinkstotal; break;
				                case 2: energenmidiqty += qty; energenmidiAmount += drinkstotal; break;
				                case 3: energenmaxiqty += qty; energenmaxiAmount += drinkstotal; break;
				            }
				        } 
				    } else if (drink == 3) {
				        if (size >= 1 && size <= 3) { 
				            System.out.print("How many? "); 
				            int qty = scn.nextInt(); 
				            drinkstotal = qty * sizePrice[size - 1]; // adjust for 0-based index
				            System.out.println("Added order: " + qty + " " + drinks[2] + " (Size: " + sizes[size - 1] + ") = " + drinkstotal); 
				            switch (size) {
				                case 1: kopikominiqty += qty; kopikominiAmount += drinkstotal; break;
				                case 2: kopikomidiqty += qty; kopikomidiAmount += drinkstotal; break;
				                case 3: kopikomaxiqty += qty; kopikomaxiAmount += drinkstotal; break;
				            }
				        }
				    }
			        orderMore();
		}
		
		public static void pastryMenu() {
			int qty = 0;
			System.out.println("\n--------------------\n PASTRIES\n--------------------\n1. Pandesal ₱10.00\n2. Monay    ₱15.00\n3. Putok    ₱25.00\n");
		    System.out.print("What would you like to order? ");
		    int pastryChoice = scn.nextInt();
		    
		    	switch (pastryChoice) {
		 	    	case 1 : System.out.print("How many? "); //PANDESAL
			 	    		 qty = scn.nextInt();
			 	    		 pastrytotal = qty * pastryPrice[pastryChoice - 1];
			 	    		 pandesalqty += qty; pandesalAmount += pastrytotal; break;
		 	    	case 2 : System.out.print("How many? "); //MONAY
	 	    		 		 qty = scn.nextInt();
	 	    		 		 pastrytotal = qty * pastryPrice[pastryChoice - 1];
	 	    		 		 monayqty += qty; monayAmount += pastrytotal; break;
		 	    	case 3 : System.out.print("How many? "); //PUTOK
		 	    			 qty = scn.nextInt();
		 	    			 pastrytotal = qty * pastryPrice[pastryChoice - 1]; 
		 	    			 putokqty += qty; putokAmount += pastrytotal; break;
		 	    	default: System.out.println("Invalid order");
	    			 		 pastryMenu();
		 	    }
		    System.out.println("Added order: " + qty + " " + pastry[pastryChoice - 1] + " = ₱" + pastrytotal);
		    orderMore();
		}
		
		public static void orderMore() {
			System.out.print("Order more?\n1. Yes\n2. No\n ");
		    int again = scn.nextInt();
		    
		    switch (again) {
		    case 1 : addOrder(); break;
		    case 2 : return;
		    default: System.out.println("Invalid input\n");
	    			 orderMore();
		    }
		}
		
		public static void viewOrder() {
			double orderAmount = milominiAmount + milomidiAmount + milomaxiAmount + energenminiAmount + energenmidiAmount + energenmaxiAmount + kopikominiAmount + 
								kopikomidiAmount +kopikomaxiAmount + pandesalAmount + monayAmount + putokAmount;
			if (orderAmount == 0) {
			        System.out.println("No order placed.");
			        return;
			    }
			else {
				System.out.println("QTY      ITEM          PRICE     TOTAL (₱)");
				if (milominiqty>0) 	  {System.out.println(milominiqty	 + "     " + drinks[0] + " - " 	 	 	+ sizes[0] 		 + "     "  + sizePrice[0] + "      " + milominiAmount);}
				if (milomidiqty>0) 	  {System.out.println(milomidiqty	 + "     " + drinks[0] + " - " 		 	+ sizes[1] 		 + "     "  + sizePrice[1] + "      " + milomidiAmount);}
				if (milomaxiqty>0) 	  {System.out.println(milomaxiqty	 + "     " + drinks[0] + " - " 			+ sizes[2] 		 + "     "  + sizePrice[2] + "      " + milomaxiAmount);}
				if (energenminiqty>0) {System.out.println(energenminiqty + "     " + drinks[1] + " - " 			+ sizes[0] 		 + "  " 	+ sizePrice[0] + "      " + energenminiAmount);}
				if (energenmidiqty>0) {System.out.println(energenmidiqty + "     " + drinks[1] + " - " 		 	+ sizes[1] 		 + "  " 	+ sizePrice[1] + "      " + energenmidiAmount);}
				if (energenmaxiqty>0) {System.out.println(energenmaxiqty + "     " + drinks[1] + " - " 			+ sizes[2] 		 + "  " 	+ sizePrice[2] + "      " + energenmaxiAmount);}
				if (kopikominiqty>0)  {System.out.println(kopikominiqty  + "     " + drinks[2] + " - "  		+ sizes[0] 		 + "   " 	+ sizePrice[0] + "      " + kopikominiAmount);}
				if (kopikomidiqty>0)  {System.out.println(kopikomidiqty  + "     " + drinks[2] + " - " 			+ sizes[1]  	 + "   " 	+ sizePrice[1] + "      " + kopikomidiAmount);}
				if (kopikomaxiqty>0)  {System.out.println(kopikomaxiqty  + "     " + drinks[2] + " - " 	  		+ sizes[2] 		 + "   " 	+ sizePrice[2] + "      " + kopikomaxiAmount);}
				if (pandesalqty>0) 	  {System.out.println(pandesalqty 	 + "     " + pastry[0] + "        " 	+ pastryPrice[0] +"      " 	+ pandesalAmount);}
				if (monayqty>0) 	  {System.out.println(monayqty 		 + "     " + pastry[1] + "           " + pastryPrice[1] +"      " 	+ monayAmount);}
				if (putokqty>0) 	  {System.out.println(putokqty 		 + "     " + pastry[2] + "           " + pastryPrice[2] + "      " + putokAmount);}
				                	   System.out.println("SUBTOTAL                         " + orderAmount);
			}
		}
		
		public static void removeItem() {
		    // Check if there are any items to remove
			if (milominiqty == 0 && milomidiqty == 0 && milomaxiqty == 0 && energenminiqty == 0 && energenmidiqty == 0 && energenmaxiqty == 0 && 
			    kopikominiqty == 0 && kopikomidiqty == 0 && kopikomaxiqty == 0 && pandesalqty == 0 && monayqty == 0 && putokqty == 0) {
			        System.out.println("No orders to remove.");
			        return;
			}
			System.out.println("Which item would you like to remove?");
		    viewOrder(); // Display current orders for reference
		    System.out.println("\n1. Milo Mini\n2. Milo Midi\n3. Milo Maxi\n4. Energen Mini\n5. Energen Midi\n6. Energen Maxi\n7. Kopiko Mini\n"
		    		+ "8. Kopiko Midi\n9. Kopiko Maxi\n10. Pandesal\n11. Monay\n12. Putok");
		    System.out.print("Enter the item number to remove: ");
		    int itemNumber = scn.nextInt();
		    switch (itemNumber) {
			    case 1: //Milo Mini
			    	if (milominiqty > 0) { 
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							milominiqty--;
							milominiAmount -= sizePrice[0];
							System.out.println("Removed 1 Milo Mini from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();			    
					    }
			        } else {
			            System.out.println("No Milo Mini to remove.\n");
			        }break;
			    case 2: //Milo Midi
			    	if (milomidiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							milomidiqty--;
							milomidiAmount -= sizePrice[1];
							System.out.println("Removed 1 Milo Midi from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();			    
					    }
			        } else {
			            System.out.println("No Milo Midi to remove.\n");
			        }break;
			    case 3: //Milo Maxi
			    	if (milomaxiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							milomaxiqty--;
							milomaxiAmount -= sizePrice[2];
							System.out.println("Removed 1 Milo Maxi from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();			    
					    }
			        } else {
			            System.out.println("No Milo Maxi to remove.\n");
			        }break;
			    case 4: //Energen Mini
			    	if (energenminiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							energenminiqty--;
							energenminiAmount -= sizePrice[0];
							System.out.println("Removed 1 Energen Mini from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();			    
					    }
			        } else {
			            System.out.println("No Energen Mini to remove.\n");
			        }break;
			    case 5: //Energen Midi
			    	if (energenmidiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							energenmidiqty--;
							energenmidiAmount -= sizePrice[1];
							System.out.println("Removed 1 Energen Midi from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n"); 
					    	removeItem();			    
					    }
			        } else {
			            System.out.println("No Energen Midi to remove.\n");
			        }break;
			    case 6: //Energen Maxi
			    	if (energenmaxiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							energenmaxiqty--;
							energenmaxiAmount -= sizePrice[2];
							System.out.println("Removed 1 Energen Maxi from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Energen Maxi to remove.\n");
			        }break;
			    case 7: //Kopiko Mini
			    	if (kopikominiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							kopikominiqty--;
							kopikominiAmount -= sizePrice[0];
							System.out.println("Removed 1 Kopiko Mini from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Kopiko Mini to remove.\n");
			        }break;
			    case 8: //Kopiko Midi
			    	if (kopikomidiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							kopikomidiqty--;
							kopikomidiAmount -= sizePrice[1];
							System.out.println("Removed 1 Kopiko Midi from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Kopiko Midi to remove.\n");
			        }break;
			    case 9: //Kopiko Maxi
			    	if (kopikomaxiqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							kopikomaxiqty--;
							kopikomaxiAmount -= sizePrice[2];
							System.out.println("Removed 1 Kopiko Maxi from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Kopiko Maxi to remove.\n");
			        }break;
			    case 10: //Pandesal
			    	if (pandesalqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							pandesalqty--;
							pandesalAmount -= pastryPrice[0]; 
							System.out.println("Removed 1 Pandesal from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Pandesal to remove.\n");
			        }break;
			    case 11: //Monay
			    	if (monayqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							monayqty--;
							monayAmount -= pastryPrice[1]; 
							System.out.println("Removed 1 Monay from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Monay to remove.\n");
			        }break;
			    case 12: //Putok
			    	if (putokqty > 0) {
			    		System.out.print("Are you sure you want to remove this item?\n1. Yes\n2. No ");
			    		int ans = scn.nextInt();
			    			if(ans == 1) {
							putokqty--;
							putokAmount -= pastryPrice[2]; 
							System.out.println("Removed 1 Putok from your order.");
						} else if (ans == 2) {
							System.out.println("No item removed");
				            return;
						} else {
					    	System.out.println("Invalid input\n");
					    	removeItem();
					    }
			        } else {
			            System.out.println("No Putok to remove.\n");
			        }break;
			    default:
			    	System.out.println("Invalid item number.");
			    	removeItem();
		    }
		}
		
		public static void cancelTrans() {
			double orderAmount = milominiAmount + milomidiAmount + milomaxiAmount + energenminiAmount + energenmidiAmount + energenmaxiAmount + kopikominiAmount + kopikomidiAmount + 
								 kopikomaxiAmount + pandesalAmount + monayAmount + putokAmount;
			if (orderAmount == 0) {
				System.out.println("You don't have transaction yet.");
			}else {
				System.out.print("Are you sure you want to cancel the transaction?\n1. Yes\n2. No ");
				int ans = scn.nextInt();
    			if(ans == 1) {
					System.out.println("Canceled the entire transaction.");
					milominiqty    = 0; milomidiqty    = 0; milomaxiqty    = 0; milominiAmount    = 0; milomidiAmount    = 0; milomaxiAmount    = 0; 
					energenminiqty = 0; energenmidiqty = 0; energenmaxiqty = 0; energenminiAmount = 0; energenmidiAmount = 0; energenmaxiAmount = 0;
					kopikominiqty  = 0; kopikomidiqty  = 0; kopikomaxiqty  = 0; kopikominiAmount  = 0; kopikomidiAmount  = 0; kopikomaxiAmount  = 0;
					pandesalqty    = 0; monayqty       = 0; putokqty       = 0; pandesalAmount    = 0; monayAmount       = 0; putokAmount       = 0;
					drinkstotal    = 0; pastrytotal    = 0;  //to reset the transaction
				}else if (ans == 2) {
					return;
				}else {
			    	System.out.println("Invalid input\n");
			    	cancelTrans();
			    }
			}
		}
		
		public static void checkout() {
			double orderAmount = milominiAmount	  + milomidiAmount 	 + milomaxiAmount 	+ energenminiAmount + energenmidiAmount + energenmaxiAmount + 
								 kopikominiAmount + kopikomidiAmount + kopikomaxiAmount + pandesalAmount 	+ monayAmount 		+ putokAmount;
			double pay = 0.00;
			if (orderAmount == 0) {
				System.out.println("You don't have transaction yet.");
			}else {
				System.out.println("Are you sure you want to checkout now?\n1. Yes\n2. No ");
				int ans = scn.nextInt();
    			if(ans == 1) {
					System.out.println("Are you a PWD?\n1. Yes\n2. No ");
					int pwd = scn.nextInt();
					System.out.println("Are you a senior citizen?\n1. Yes\n2. No ");
					int senior = scn.nextInt();
					if (pwd == 1 && senior == 1) {
						double discount = orderAmount*0.20;
						double fAmount  = orderAmount - (discount*2);
						double VAT      = 0.20 * fAmount;
						double VSales 	= fAmount - VAT;
						Date now 		= new Date();
						System.out.println("Total Amount = " + fAmount);
						System.out.print("Put payment here => ");
						pay = scn.nextDouble();
						if(pay < fAmount) {
							System.out.println("Not enough payment");
							checkout();
						}else {
							double change   = pay - fAmount;
							System.out.println("          Four Queens and a King\n--------------------------------------------");
							System.out.println("          Bulacan State University\n  Mc Arthur Highway  Malolos City, Bulacan");
							System.out.println(" Tell us about your experience in our shop\n             www.FQaaK.com");
							System.out.println("   Date : " + now + "\n--------------------------------------------");
							viewOrder();
							System.out.println("SENIOR DISCOUNT                  " + discount + "-");
							System.out.println("PWD DISCOUNT                     " + discount + "-");
							System.out.println("TOTAL DISCOUNT                   " + discount*2 + "-");
							System.out.println("DISCOUNT REASON                  " + "PWD & SENIOR");
							System.out.println("TOTAL                            " + fAmount);
							System.out.println("Cash Tendered                    " + pay);
							System.out.println("Change                           " + change);
							System.out.println("Vatable Sales                    " + String.format("%.2f", VSales));
							System.out.println("VAT                              " + VAT);
							System.out.println("       Thank you, please come again.");
						}	
					}else if (pwd == 1 && senior == 2) {
						double discount = orderAmount*0.20;
						double fAmount 	= orderAmount - discount;
						double VAT 		= 0.20 * fAmount;
						double VSales 	= fAmount - VAT;
						Date now 		= new Date();
						System.out.println("Total Amount = " + fAmount);
						System.out.print("Put payment here => ");
						pay = scn.nextDouble();
						if(pay < fAmount) {
							System.out.println("Not enough payment");
							checkout();
						}else {
							double change   = pay - fAmount;
							System.out.println("          Four Queens and a King\n--------------------------------------------");
							System.out.println("          Bulacan State University\n  Mc Arthur Highway  Malolos City, Bulacan");
							System.out.println(" Tell us about your experience in our shop\n             www.FQaaK.com");
							System.out.println("   Date : " + now + "\n--------------------------------------------");
							viewOrder();
							System.out.println("PWD DISCOUNT                     " + discount + "-");
							System.out.println("TOTAL DISCOUNT                   " + discount + "-");
							System.out.println("DISCOUNT REASON                  " + "PWD");
							System.out.println("TOTAL                            " + fAmount);
							System.out.println("Cash Tendered                    " + pay);
							System.out.println("Change                           " + change);
							System.out.println("Vatable Sales                    " + String.format("%.2f", VSales));
							System.out.println("VAT                              " + VAT);
							System.out.println("       Thank you, please come again.");
						}
					}else if (pwd == 2 && senior == 1) {
						double discount = orderAmount*0.20;
						double fAmount 	= orderAmount - discount;
						double VAT 		= 0.20 * fAmount;
						double VSales 	= fAmount - VAT;
						Date now 		= new Date();
						System.out.println("Total Amount = " + fAmount);
						System.out.print("Put payment here => ");
						pay = scn.nextDouble();
						if(pay < fAmount) {
							System.out.println("Not enough payment");
							checkout();
						}else {
							double change   = pay - fAmount;
							System.out.println("          Four Queens and a King\n--------------------------------------------");
							System.out.println("          Bulacan State University\n  Mc Arthur Highway  Malolos City, Bulacan");
							System.out.println(" Tell us about your experience in our shop\n             www.FQaaK.com");
							System.out.println("   Date : " + now + "\n--------------------------------------------");
							viewOrder();
							System.out.println("SENIOR DISCOUNT                  " + discount + "-");
							System.out.println("TOTAL DISCOUNT                   " + discount + "-");
							System.out.println("DISCOUNT REASON                  " + "SENIOR");
							System.out.println("TOTAL                            " + fAmount);
							System.out.println("Cash Tendered                    " + pay);
							System.out.println("Change                           " + change);
							System.out.println("Vatable Sales                    " + String.format("%.2f", VSales));
							System.out.println("VAT                              " + VAT);
							System.out.println("       Thank you, please come again.");
						}
					}else if (pwd == 2 && senior == 2) {
						double VAT 	  = 0.20 * orderAmount;
						double VSales = orderAmount - VAT;
						Date now 	  = new Date();
						System.out.println("Total Amount = " + orderAmount);
						System.out.print("Put payment here => ");
						pay = scn.nextDouble();
						if(pay < orderAmount) {
							System.out.println("Not enough payment");
							checkout();
						}else {
							double change = pay - orderAmount;
							System.out.println("          Four Queens and a King\n--------------------------------------------");
							System.out.println("          Bulacan State University\n  Mc Arthur Highway  Malolos City, Bulacan");
							System.out.println(" Tell us about your experience in our shop\n             www.FQaaK.com");
							System.out.println("   Date : " + now + "\n--------------------------------------------");
							viewOrder();
							System.out.println("TOTAL                            " + orderAmount);
							System.out.println("Cash Tendered                    " + pay);
							System.out.println("Change                           " + change);
							System.out.println("Vatable Sales                    " + String.format("%.2f", VSales));
							System.out.println("VAT                              " + VAT);
							System.out.println("       Thank you, please come again.");
						}
					}else {
						System.out.println("Invalid input");
						checkout();
					}
					
					milominiqty    = 0; milomidiqty    = 0; milomaxiqty    = 0; milominiAmount    = 0; milomidiAmount    = 0; milomaxiAmount    = 0; 
					energenminiqty = 0; energenmidiqty = 0; energenmaxiqty = 0; energenminiAmount = 0; energenmidiAmount = 0; energenmaxiAmount = 0;
					kopikominiqty  = 0; kopikomidiqty  = 0; kopikomaxiqty  = 0; kopikominiAmount  = 0; kopikomidiAmount  = 0; kopikomaxiAmount  = 0;
					pandesalqty    = 0; monayqty       = 0; putokqty       = 0; pandesalAmount    = 0; monayAmount       = 0; putokAmount       = 0;
					drinkstotal    = 0; pastrytotal    = 0;  //to reset the transaction after checkout
					
				} else if (ans == 2) {
					return;
				} else {
			    	System.out.println("Invalid input\n");
			    	checkout();
			    }
			}
		}
		
		public static void main(String[] args) {
			while (true) {
	            decision();
	            	System.out.print("Choose an option (1-6): ");
	            	int choice = scn.nextInt();
	            	scn.nextLine();
	            		switch (choice) {
	            			case 1: addOrder(); break;
	            			case 2: viewOrder(); break;
	            			case 3: removeItem(); break;
	            			case 4: cancelTrans(); break;
	            			case 5: checkout();
	            					break;
	            			case 6: System.out.println("Exiting the program.\n\nMeanwhile..."); break;
	            			default : System.out.println("Invalid choice. Please try again.");
	            		}	            	
			}
		}
}