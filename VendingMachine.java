public class VendingMachine {
        private int itemCount;
        private boolean poweredOn;

        public VendingMachine(int initialItems){
            this.itemCount = initialItems;
            this.poweredOn = false;
        }

        public void powerOn(){
            if(poweredOn){
                throw new IllegalStateException("Machine already on");
            }
            poweredOn = true;
        }

        public void powerOff(){
            poweredOn = false;
        }

        public boolean isPoweredOn(){
            return poweredOn;
        }

        public void dispenseItem(){
            if (!poweredOn){
                throw new IllegalStateException("Machine is off");
            }
            if (itemCount <= 0){
                throw new IllegalStateException("Out of stock");
            }
            itemCount--;
        }

        public int getItemCount(){
            return itemCount;
        }
    }

