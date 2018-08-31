from IPython import external
from iconservice import *


class POST_Token(IconScoreBase):

    __DESIGNATOR = 'designator'
    __IS_DELIVERED = 'is_delivered'

    def __init__(self, db: IconScoreDatabase) -> None:
        super().__init__(db)

        self.__designator = VarDB(self.__DESIGNATOR, db, value_type=str)
        self.__is_delivered = VarDB(self.__IS_DELIVERED, db, value_type=bool)

    def on_install(self, designator, delivered) -> None:
        super().on_install()

        # self.__designator.set(designator)

        self.__designator = designator

        self.__is_delivered = delivered

    def on_update(self) -> None:
        super().on_update()
    
    @external(readonly=True)
    def hello(self) -> str:
        print(f'Hello, world!')
        return "Hello"

    @external(readonly=True)
    def get_delivered_state(self) -> str:

        if self.__is_delivered:
            return "The mail was delivered"
        else:
            return "The mail is not delivered"

    @external
    def delivered(self)->str:
        if self.__is_delivered:
            print(f'The mail has already delivered')
        # elif str(self.msg.sender) == str(self.__designator.get()):
        elif str(self.msg.sender) == str(self.__designator):
            print(f'Change state of the mail')
            self.__is_delivered = True
        else:
            print(f'Error ')






